package com.musicManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.musicManage")
public class MusicManageApplication{

	public static void main(String[] args) {
 
		SpringApplication.run(MusicManageApplication.class, args);
		
	}
}
