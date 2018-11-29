package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageService {
	/**
	 * 分析歌单列表
	 * @return
	 * @throws Exception
	 */
	List<MusicDO> analyze() throws Exception;
	/**
	 * 分析歌单歌曲
	 * @param music
	 * @return
	 * @throws Exception
	 */
	List<MusicDO> analyzePlaylist(MusicDO music) throws Exception;
}
