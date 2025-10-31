package com.operation.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PropertiesConfig {


	@Value("${UPLOAD.FOLDER}")
	private String uploadFolder;
	
	@Value("${DOWNLOAD.FOLDER}")
	private String downloadFolder;
	
	@Value("${CLASS.PATH}")
	private String classPath;
	
	@Value("${TEMP.FOLDER}")
	private String tempFolder;
	
	@Value("${SECRET.KEY}")
    private String SECRET_KEY;

	
	
	public String getClassPath() {
		return classPath;
	}

	public String getUploadFolder() {
		return getClassPath()+File.separator + uploadFolder +File.separator;
	}
	
	public String getDownloadFolder() {
		return getClassPath()+File.separator + downloadFolder +File.separator;
	}
	
	public String getTempFolder() {
		return getClassPath()+File.separator + tempFolder +File.separator;
	}
	
	public String getSecretKey() {
		return StringUtils.hasText(SECRET_KEY) ? SECRET_KEY : "ariantechsolutions1234";
	}
//	
	

}
