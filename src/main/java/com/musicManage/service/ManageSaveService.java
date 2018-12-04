package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageSaveService {
	/**
	 * 去重入库
	 * @param list
	 */
	void insert(List<MusicDO> list);
}
