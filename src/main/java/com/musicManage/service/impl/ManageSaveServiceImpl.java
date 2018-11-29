package com.musicManage.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.musicManage.dao.MusicDao;
import com.musicManage.dao.model.MusicDO;
import com.musicManage.service.ManageSaveService;

@Service
public class ManageSaveServiceImpl implements ManageSaveService{
	@Autowired
	private MusicDao musicDao;
	
	@Override
	public void insert(List<MusicDO> list) {
		for (MusicDO musicDO : list) {
			System.out.println(JSONObject.toJSONString(musicDO));
			MusicDO music=new MusicDO();
			music.setSongId(musicDO.getSongId());
			music.setOrigin(musicDO.getOrigin());
			List<MusicDO> list2=musicDao.select(music);
			if(CollectionUtils.isEmpty(list2)) {
				musicDao.insert(musicDO);
			}else {
				System.out.println("重复"+JSONObject.toJSONString(list2.get(0)));
			}
			
		}		
	}

}
