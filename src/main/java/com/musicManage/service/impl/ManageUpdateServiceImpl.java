package com.musicManage.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.musicManage.bean.JsonRootBean;
import com.musicManage.dao.MusicDao;
import com.musicManage.dao.model.MusicDO;
import com.musicManage.service.ManageUpdateService;
import com.musicManage.util.FileUtil;
import com.musicManage.util.HttpsUtils;

import sun.misc.BASE64Encoder;
import us.codecraft.webmagic.Page;


@Service
public class ManageUpdateServiceImpl implements ManageUpdateService{
	@Autowired
	private MusicDao musicDao;
	@Value("${Net_Origin}")
	private String Net_origin;
	@Value("${QQ_Origin}")
	private String QQ_origin;
	@Value("${downloadFileDir}")
	private String downloadFileDir;
	
	public  String cookies = "JSESSIONID-WYYY=; _iuqxldmzr_=; _ntes_nnid=11111111111111111111111111111111,1532077868777; _ntes_nuid=11111111111111111111111111111111; __utma=; __utmz=; __oc_uuid=; __utma=; __utmz=; usertrack=; _ga=; WM_TID=; __utmb=; __utmc=; WM_NI=; WM_NIKE=";

	
	@Override
	public void saveFile() {
		List<MusicDO> list=musicDao.selectNoFile();
		List<MusicDO> newlist=new ArrayList<>();
		for (MusicDO musicDO : list) {
			if(musicDO.getOrigin().equals(Net_origin)) {
				MusicDO music=NetDown(musicDO);
				newlist.add(music);
			}else if(musicDO.getOrigin().equals(QQ_origin)) {
				MusicDO music=QQDown(musicDO);
				newlist.add(music);
			}
			
		}
		updateAddress(newlist);
	}

	@Override
	public void updateAddress(List<MusicDO> list) {
		for (MusicDO musicDO : list) {
			musicDao.updateAddress(musicDO);
		}
		
	}
	
	public MusicDO NetDown(MusicDO musicDO) {
		MusicDO music=new MusicDO();
		music.setOrigin(musicDO.getOrigin());
		music.setSongId(musicDO.getSongId());
		try {
			String url=api(musicDO);
			String dest=downloadFileDir+"/"+musicDO.getOrigin()+"/"+musicDO.getPlaylistName()+"/"+
			//musicDO.getSongId()+"_"+
			musicDO.getSongName();
			dest = FileUtil.ValidFileName(dest);
			dest=dest+".mp3";
			music.setAddress(FileDown(url, dest, musicDO.getOrigin()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return music;
	}
		
	public MusicDO QQDown(MusicDO musicDO) {
		MusicDO music=new MusicDO();
		music.setOrigin(musicDO.getOrigin());
		music.setSongId(musicDO.getSongId());
		try {
			HttpsUtils h = new HttpsUtils();
			CloseableHttpClient httpClient = h.getHttpClient();
			HttpPost httpPost = new HttpPost("http://www.douqq.com/qqmusic/qqapi.php");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("mid", musicDO.getSongExtra()));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity resEntity = httpResponse.getEntity();
			String result = EntityUtils.toString(resEntity, "utf-8");
			//System.out.println(result);
			result = result.replace("\\", "");
			result = result.replace("\\\\", "");
			result = result.substring(1, result.length() - 1);
			Pattern pat = Pattern.compile("\"albumname\":.*\",\"s");
	        Matcher mat = pat.matcher(result);
	        if(mat.find()){
	        	String mac=mat.group();
	        	String oldname=mac.substring(13, mac.length()-4);
	        	String newname=oldname.replace("\"", "");
	        	result=result.replace(oldname, newname);
	        }
	        Pattern pat2 = Pattern.compile("\"songname\":.*\",\"a");
	        Matcher mat2 = pat2.matcher(result);
	        if(mat2.find()){
	        	String mac=mat2.group();
	        	String oldname=mac.substring(12, mac.length()-4);
	        	String newname=oldname.replace("\"", "");
	        	result=result.replace(oldname, newname);
	        }
			//System.out.println(result);
			JsonRootBean jsonRootBean = JSONObject.parseObject(result, new TypeReference<JsonRootBean>() {});
			String url=null;
			String dest=downloadFileDir+"/"+musicDO.getOrigin()+"/"+musicDO.getPlaylistName()+"/"
			//+musicDO.getSongId()+"_"
			+musicDO.getSongName();
			dest = FileUtil.ValidFileName(dest);
			if(musicDO.getQuality().contains("flac")) {
				url=jsonRootBean.getFlac();
				dest=dest+".flac";
			}else if(musicDO.getQuality().contains("320k")) {
				url=jsonRootBean.getMp3_h();
				dest=dest+".mp3";
			}else if (musicDO.getQuality().contains("128k")) {
				url=jsonRootBean.getMp3_l();
				dest=dest+".mp3";
			}
			music.setAddress(FileDown(url, dest, musicDO.getOrigin()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return music;
	}
	
	public String  FileDown(String url,String dest,String origin) {
		try {
			if(StringUtils.isBlank(url)) {
				System.out.println(dest+"版权所限 无法下载");
				return null;
			}
			InputStream is;
			
			System.out.println(dest);
			String dest2=dest.replace("/"+dest.split("/")[dest.split("/").length-1],"");
			File fi=new File(dest2);
			if(!fi.exists()) {
				fi.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(dest);
			URL temp = new URL(url.trim());
			URLConnection uc = temp.openConnection();
			uc.addRequestProperty("User-Agent",
					"Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
			if (origin.equals(QQ_origin)) {
				uc.addRequestProperty("Referer", "https://y.qq.com/portal/player.html");
			}
			is = temp.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int length;
			byte[] bytes = new byte[1024 * 20];
			while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
				fos.write(bytes, 0, length);
			}
			bos.close();
			fos.close();
			bis.close();
			is.close();
			return dest;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// api
	public String api(MusicDO musicDO) throws Exception {
		String url=null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			// json
			// String first_param = "{rid:\"\", offset:\"offset_param\", total:\"true\",
			// limit:\"20\", csrf_token:\"\"}";
			//br : musicDO.getQuality()
			String first_param = "{ids:\"[" + musicDO.getSongId() + "]\", br: \"" + "32000"
					+ "\", csrf_token:\"\"}";
			// first_param = first_param.replace("offset_param", offset + "");
			// 参数加密
			// 16位随机字符串，直接FFF
			// String secKey = new BigInteger(100, new
			// SecureRandom()).toString(32).substring(0, 16);
			String secKey = "FFFFFFFFFFFFFFFF";
			// 两遍ASE加密
			String encText = aesEncrypt(aesEncrypt(first_param, "0CoJUm6Qyw8W8jud"), secKey);
			String encSecKey = rsaEncrypt();
			HttpPost httpPost = new HttpPost("http://music.163.com/weapi/song/enhance/player/url?csrf_token=");
			httpPost.addHeader("Referer", "http://music.163.com/");
			httpPost.addHeader("Cookie", cookies);
			httpPost.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
			List<NameValuePair> ls = new ArrayList<NameValuePair>();
			ls.add(new BasicNameValuePair("params", encText));
			ls.add(new BasicNameValuePair("encSecKey", encSecKey));
			UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(ls, "utf-8");
			httpPost.setEntity(paramEntity);
			response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String json = EntityUtils.toString(entity, "utf-8").toString();
				JSONObject jsStr = JSONObject.parseObject(json);
				String json1 = jsStr.getString("data").replace("[", "").replace("]", "");
				JSONObject jsStr1 = JSONObject.parseObject(json1);
				url=jsStr1.getString("url");
			}
			response.close();
			httpclient.close();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	/**
	 * ASE-128-CBC加密模式可以需要16位
	 *
	 * @param src
	 *            加密内容
	 * @param key
	 *            密钥
	 * @return
	 */
	public  String aesEncrypt(String src, String key) throws Exception {
		String encodingFormat = "UTF-8";
		String iv = "0102030405060708";
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = key.getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		// 使用CBC模式，需要一个向量vi，增加加密算法强度
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(src.getBytes(encodingFormat));
		return new BASE64Encoder().encode(encrypted);
	}

	public  String rsaEncrypt() {
		String secKey = "257348aecb5e556c066de214e531faadd1c55d814f9be95fd06d6bff9f4c7a41f831f6394d5a3fd2e3881736d94a02ca919d952872e7d0a50ebfa1769a7a62d512f5f1ca21aec60bc3819a9c3ffca5eca9a0dba6d6f7249b06f5965ecfff3695b54e1c28f3f624750ed39e7de08fc8493242e26dbc4484a01c76f739e135637c";
		return secKey;
	}

	@Override
	public void updateExcetionFile(MusicDO music) {
		musicDao.updateAddress(music);
	}

	@Override
	public List<MusicDO> selectFile(MusicDO music) {
		System.out.println(JSONObject.toJSONString(music));
		return musicDao.select(music);
	}

	@Override
	public void manupdateFile(MusicDO music) {
		MusicDO musicDO=new MusicDO();
		musicDO.setSongId(music.getSongId());
		musicDO.setOrigin(music.getOrigin());
		List<MusicDO> list=musicDao.select(musicDO);
		if(CollectionUtils.isNotEmpty(list)) {
			if(StringUtils.isNotBlank(music.getAddress())) {
				String dest=downloadFileDir+"/"+list.get(0).getOrigin()+"/"+list.get(0).getPlaylistName();
				dest=FileUtil.ValidFileName(dest)+"/"+music.getAddress();
				music.setAddress(dest);
				music.setRemark("人工补全");
			}
			musicDao.manualupdate(music);
		}
		
	}

	@Override
	public List<MusicDO> selectNoCopyRightFile() {
		List<MusicDO> list=musicDao.selectNoCopyRightFile();
		try {
			HttpsUtils h = new HttpsUtils();
			CloseableHttpClient httpClient = h.getHttpClient();
			HttpPost httpPost = new HttpPost("http://music.sonimei.cn/");
			httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
			httpPost.addHeader("X-Requested-With","XMLHttpRequest");
			for (MusicDO musicDO : list) {
					List<NameValuePair> nvps = new ArrayList<NameValuePair>();
					nvps.add(new BasicNameValuePair("filter", "id"));
					nvps.add(new BasicNameValuePair("input", musicDO.getSongId()));
					nvps.add(new BasicNameValuePair("page", "1"));
					String origin = "";
					if (musicDO.getOrigin().equals("NetEasemusic")) {
						origin = "netease";
					} else if (musicDO.getOrigin().equals("QQmusic")) {
						origin = "qq";
					}
					nvps.add(new BasicNameValuePair("type", origin));
					httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
					try {
						HttpResponse httpResponse = httpClient.execute(httpPost);
						HttpEntity resEntity = httpResponse.getEntity();
						String result = EntityUtils.toString(resEntity, "utf-8");
						Page page = new Page();
						page.setRawText(result);
						String address = page.getJson().jsonPath("$.data[0].url").get();
						System.out.println(address);
						musicDO.setAddress(address);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
