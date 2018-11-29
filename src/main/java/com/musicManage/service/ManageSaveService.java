package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageSaveService {
	
	void insert(List<MusicDO> list);
}
