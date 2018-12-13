package com.musicManage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musicManage.dao.model.MusicDO;



@Mapper
public interface MusicDao {
	
	List<MusicDO> select(MusicDO music);
	
	void insert(MusicDO music);
	
	void updateAddress(MusicDO music);
	
	List<MusicDO> selectNoFile();
	
	void manualupdate(MusicDO music);

	List<MusicDO> selectNoCopyRightFile();
}
