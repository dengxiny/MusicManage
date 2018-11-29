package com.musicManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.musicManage.bean.Root;
import com.musicManage.bean.Tracks;
import com.musicManage.dao.model.MusicDO;
import com.musicManage.service.ManageService;
import com.musicManage.util.HttpsUtils;

import us.codecraft.webmagic.Page;

@Service("NetEasemusicManageService")
public class NetEasemusicManageServiceImpl implements ManageService{
	@Value("${Net_UserPlaylistId}")
	private String uid;
	@Value("${Net_Origin}")
	private String origin;
	
	@Override
	public List<MusicDO> analyze() throws Exception {
		HttpsUtils h=new HttpsUtils();
		CloseableHttpClient httpClient =h.getHttpClient();
		HttpGet httpGet=new HttpGet("http://music.163.com/api/user/playlist/?offset=0&limit=1001&uid="+uid);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		HttpResponse httpResponse=httpClient.execute(httpGet);
		HttpEntity resEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(resEntity,"utf-8");
		Page page=new Page();
		page.setRawText(result);
		List<MusicDO> music=new ArrayList<>();
		List<String> playlist=page.getJson().jsonPath("$.playlist[*]").all();
		for (String string : playlist) {
			page=new Page();
			page.setRawText(string);
			MusicDO musicDO=new MusicDO();
			musicDO.setOrigin(origin);
			musicDO.setPlaylistId(page.getJson().jsonPath("$.id").get());
			musicDO.setPlaylistName(page.getJson().jsonPath("$.name").get());
			//System.out.println(JSONObject.toJSONString(musicDO));
			List<MusicDO> playlistMusics=analyzePlaylist(musicDO);
			music.addAll(playlistMusics);
		}
		return music;
	}

	@Override
	public List<MusicDO> analyzePlaylist(MusicDO music) throws Exception {
		HttpsUtils h=new HttpsUtils();
		CloseableHttpClient httpClient =h.getHttpClient();
		HttpGet httpGet=new HttpGet("http://music.163.com/api/playlist/detail?id="+music.getPlaylistId()+"&limit=2000");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		HttpResponse httpResponse=httpClient.execute(httpGet);
		HttpEntity resEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(resEntity,"utf-8");
		Page page=new Page();
		page.setRawText(result);
		Root r=JSONObject.parseObject(result,new TypeReference<Root>() {});
		List<Tracks> tracks=r.getResult().getTracks();
		List<MusicDO> list=new ArrayList<>();
		for (Tracks tracks2 : tracks) {
			try {
				MusicDO musicDO = new MusicDO();
				BeanUtils.copyProperties(music, musicDO);
				musicDO.setAlbumName(tracks2.getAlbum().getName());
				musicDO.setSingerName(tracks2.getArtists().get(0).getName());
				musicDO.setSongName(tracks2.getName());
				musicDO.setSongId(tracks2.getId().toString());
				/*musicDO.setSongExtra("原id:" + tracks2.getId().toString());
				if (tracks2.getHMusic() != null) {
					musicDO.setSongId(tracks2.getHMusic().getId().toString());
					musicDO.setQuality(tracks2.getHMusic().getBitrate().toString());
				} else if (tracks2.getMMusic() != null) {
					musicDO.setSongId(tracks2.getMMusic().getId().toString());
					musicDO.setQuality(tracks2.getMMusic().getBitrate().toString());
				} else if (tracks2.getLMusic() != null) {
					musicDO.setSongId(tracks2.getLMusic().getId().toString());
					musicDO.setQuality(tracks2.getLMusic().getBitrate().toString());
				}*/
				list.add(musicDO);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}


	
}
