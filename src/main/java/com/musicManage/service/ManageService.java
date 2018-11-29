package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageService {
	
	List<MusicDO> analyze() throws Exception;
	
	List<MusicDO> analyzePlaylist(MusicDO music) throws Exception;
}
