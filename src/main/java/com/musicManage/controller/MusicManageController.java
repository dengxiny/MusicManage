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
		String Home() {
			try {
				List<MusicDO> list=qqManageService.analyze();
				manageSaveService.insert(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "home1";
		}
	
		@RequestMapping("/NetEasemusic")
		String Home2() {
			try {
				List<MusicDO> list=netManageService.analyze();
				manageSaveService.insert(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "home2";
		}
		
		
		@RequestMapping("/save")
		String Home3() {
			try {
				updateService.saveFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "home3";
		}
		
		
		@RequestMapping("/deletezerofile")
		String Home4() {
			try {
				manageDeleteService.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "home4";
		}
		
		@RequestMapping("/updatefile")
		String Home5(MusicDO music) {
			updateService.updateExcetionFile(music);
			return "home5";
		}
		
		
		@RequestMapping("/sel")
		String Home6(MusicDO music) {
			System.out.println(music.getSongName());
			System.out.println(JSONObject.toJSONString(music));
			return JSONObject.toJSONString(updateService.selectFile(music));
		}
		
		@RequestMapping("/manupdate")
		String Home7(MusicDO music) {
			System.out.println(JSONObject.toJSONString(music));
			updateService.manupdateFile(music);
			return "home7";
		}
}
