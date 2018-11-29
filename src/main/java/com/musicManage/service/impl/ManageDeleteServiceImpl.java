package com.musicManage.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.musicManage.dao.MusicDao;
import com.musicManage.service.ManageDeleteService;

@Service
public class ManageDeleteServiceImpl implements ManageDeleteService {
	@Autowired
	private MusicDao musicDao;
	@Value("${downloadFileDir}")
	private String downloadFileDir;

	@Override
	public void delete() {
		File file = new File(downloadFileDir);
		List<File> fileList = (List<File>) FileUtils.listFiles(file,null,true);
        fileList.stream().filter(file2 -> file2.length()<5000).forEach(file2 -> System.out.println(file2.getAbsolutePath()));
	}

}
