package com.musicManage.service;

import java.util.List;

import com.musicManage.dao.model.MusicDO;

public interface ManageUpdateService {
	/**
	 * 未下载重新下载
	 */
	void saveFile();
	/**
	 * 批量更新地址
	 * @param list
	 */
	void updateAddress(List<MusicDO> list);
	/**
	 * 更新异常文件
	 * @param music
	 */
	void updateExcetionFile(MusicDO music);
	/**
	 * 查询
	 * @param music
	 * @return
	 */
	List<MusicDO> selectFile(MusicDO music);
	/**
	 * 手动更新文件
	 * @param list
	 */
	void manupdateFile(MusicDO music);
}
