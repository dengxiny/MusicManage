package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageUpdateService {
	
	void saveFile();
	
	void updateAddress(List<MusicDO> list);
	
	void updateExcetionFile(MusicDO music);
	
	List<MusicDO> selectFile(MusicDO music);
	
	void manupdateFile(MusicDO music);
}
