package com.web.client.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import com.web.client.dto.ApplicationLog;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class LoginService {
	
	static String uri = getUri();

	public ApplicationLog[] fetchAppLogs(String user, String password) {
		
		ApplicationLog[] appLogs = null;
		
			
		String strUri = uri +  "/fetchlogs?user=" + user + "&password=" + password;
		System.out.println("uri from prop: " + strUri);
		
		RestTemplate restTemplate = new RestTemplate();
	    
	    try {
	
	    	appLogs = restTemplate.getForObject(strUri, ApplicationLog[].class);
	        
	    } catch (RestClientException e) {
	        e.printStackTrace();
	    }
			
		
		return appLogs;
	}
	
	public static String getUri() {
		
		InputStream inputStream = null;
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream =  LoginService.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			uri = prop.getProperty("uri");
			//System.out.println("uri:" + uri);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return uri;
	}
	
}
