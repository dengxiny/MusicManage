package com.musicManage.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.musicManage.dao.model.MusicDO;
import com.musicManage.service.ManageDeleteService;
import com.musicManage.service.ManageSaveService;
import com.musicManage.service.ManageService;
import com.musicManage.service.ManageUpdateService;

@RestController
public class MusicManageController {
		@Resource(name="NetEasemusicManageService")
		private ManageService netManageService;
		@Resource(name="QQmusicManageService")
		private ManageService qqManageService;
		@Autowired
		private ManageSaveService manageSaveService;
		@Autowired
		private ManageUpdateService updateService;
		@Autowired
		private ManageDeleteService manageDeleteService;
		
		@RequestMapping("/QQmusic")
		public String findQQmusicPlaylist() {
			try {
				List<MusicDO> list=qqManageService.analyze();
				manageSaveService.insert(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "findQQmusicPlaylist";
		}
	
		@RequestMapping("/NetEasemusic")
		public String findNetEasemusicPlaylist() {
			try {
				List<MusicDO> list=netManageService.analyze();
				manageSaveService.insert(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "findNetEasemusicPlaylist";
		}
		
		
		@RequestMapping("/save")
		public String saveFileTolocal() {
			try {
				updateService.saveFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "saveFileTolocal";
		}
		
		/**
		 * 删除已下载但是文件内容为空的文件
		 * @return
		 */
		@RequestMapping("/deletezerofile")
		public String deleteZerofile() {
			try {
				manageDeleteService.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "deleteZerofile";
		}
		
		/**
		 * 更新文件
		 * @param music
		 * @return
		 */
		@RequestMapping("/updatefile")
		public String updateFile(MusicDO music) {
			updateService.updateExcetionFile(music);
			return "updateFile";
		}
		
		/**
		 * 查询歌曲详情
		 * @param music
		 * @return
		 */
		@RequestMapping("/sel")
		public String selSong(MusicDO music) {
			System.out.println(music.getSongName());
			System.out.println(JSONObject.toJSONString(music));
			return JSONObject.toJSONString(updateService.selectFile(music));
		}
		
		/**
		 * 手动更新打标记
		 * @param music
		 * @return
		 */
		@RequestMapping("/manupdate")
		public String manupdate(MusicDO music) {
			System.out.println(JSONObject.toJSONString(music));
			updateService.manupdateFile(music);
			return "manupdate";
		}
		
		/**
		 * 
		 * @return
		 */
		@RequestMapping("/selnocopyright")
		public List<MusicDO> manupdate() {
			return updateService.selectNoCopyRightFile();
		}
}
