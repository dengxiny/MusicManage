package com.musicManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.musicManage.dao.model.MusicDO;
import com.musicManage.service.ManageService;
import com.musicManage.util.HttpsUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

@Service("QQmusicManageService")
public class QQmusicManageServiceImpl implements ManageService{
	@Value("${QQ_UserPlaylistId}")
	private String userid;
	@Value("${QQ_Origin}")
	private String origin;
	@Value("${QQ_UserPlaylistcid}")
	private String cid;
	
	@Override
	public List<MusicDO> analyze() throws Exception {
		HttpsUtils h=new HttpsUtils();
		CloseableHttpClient httpClient =h.getHttpClient();
		HttpGet httpGet=new HttpGet("https://c.y.qq.com/rsc/fcgi-bin/fcg_get_profile_homepage.fcg?format=jsonp&inCharset=utf8&outCharset=utf-8&platform=yqq&cid="+cid+"&userid="+userid+"&reqfrom=1");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		HttpResponse httpResponse=httpClient.execute(httpGet);
		HttpEntity resEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(resEntity,"utf-8");
		Page page=new Page();
		page.setRawText(result);
		System.out.println(result);
		List<MusicDO> music=new ArrayList<>();
		List<String> list=page.getJson().jsonPath("$.data.mydiss.list[*]").all();
		for (String string : list) {
			Page page2=new Page();
			page2.setRawText(string);
			MusicDO musicDO=new MusicDO();
			musicDO.setOrigin(origin);
			musicDO.setPlaylistId(page2.getJson().jsonPath("$.dissid").get());
			musicDO.setPlaylistName(page2.getJson().jsonPath("$.title").get());
			List<MusicDO> playlistMusics=analyzePlaylist(musicDO);
			music.addAll(playlistMusics);
		}
		return music;
	}

	@Override
	public List<MusicDO> analyzePlaylist(MusicDO music) throws Exception {
		HttpsUtils h=new HttpsUtils();
		CloseableHttpClient httpClient =h.getHttpClient();
		HttpGet httpGet=new HttpGet("https://c.y.qq.com/qzone/fcg-bin/fcg_ucc_getcdinfo_byids_cp.fcg?type=1&json=1&utf8=1&onlysong=0&disstid="+music.getPlaylistId()+"&format=json&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		httpGet.setHeader("Referer","https://y.qq.com/n/yqq/");
		HttpResponse httpResponse=httpClient.execute(httpGet);
		HttpEntity resEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(resEntity,"utf-8");
		List<MusicDO> musicDOs=new ArrayList<>();
		Page page=new Page();
		page.setRawText(result);
		List<Selectable> list=page.getJson().jsonPath("$.cdlist[0].songlist[*]").nodes();
		for (Selectable string : list) {
			try {
				MusicDO musicDO = new MusicDO();
				BeanUtils.copyProperties(music, musicDO);
				Json json = new Json(string.toString());
				String sizeflac=jsonSelect("$.sizeflac", json);
				String size320=jsonSelect("$.size320", json);
				String size128=jsonSelect("$.size128", json);
				if(StringUtils.isNotBlank(sizeflac)&&!sizeflac.equals("0")) {
					musicDO.setQuality("flac:"+sizeflac);
				}else if(StringUtils.isNotBlank(size320)&&!size320.equals("0")) {
					musicDO.setQuality("320k:"+size320);
				}else if(StringUtils.isNotBlank(size128)&&!size128.equals("0")) {
					musicDO.setQuality("128k:"+size128);
				}
				musicDO.setSingerName(jsonSelect("$.singer[0].name", json));
				musicDO.setSongId(jsonSelect("$.songid", json));
				musicDO.setSongExtra(jsonSelect("$.songmid", json));
				musicDO.setAlbumName(jsonSelect("$.albumname",json));
				musicDO.setSongName(jsonSelect("$.songname", json));
				musicDOs.add(musicDO);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return musicDOs;
	}
	
	public String jsonSelect(String jsonPath,Json json) {
		String result=null;
		try {
			result=json.jsonPath(jsonPath).get();
			if(StringUtils.isBlank(result)) {
				return null;
			}
		} catch (Exception e) {
			return result;
		}
		return result;
	}
}
