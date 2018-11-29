package com.musicManage.util;

public class FileUtil {
	public static boolean isValidFileName(String fileName) {
		if (fileName == null || fileName.length() > 255) {
			return false;
		} else {
			return fileName.matches(
					"[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
		}
	}
	
	public static String ValidFileName(String name) {
		String[] dest=name.split("/");
		String destname=dest[0];
		for (int i = 1; i < dest.length; i++) {
			String d=dest[i];
			d = d.replace("?", "").replace("/", "_").replace("*", "_").replace("$", "_").replace("<", "")
					.replace(">", "").trim().replace(":", "_").replace("|", "").replace("\"", "").replaceAll("\\s*","");
			destname+="/"+d;
		}
		return destname;
	}
}
