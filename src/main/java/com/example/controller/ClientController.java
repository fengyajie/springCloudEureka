package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ClientController {
	

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public void dc() {
		//throw new RuntimeException("www");
		/*
		 * try { Thread.sleep(5000L); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		  List<String> servicesList = discoveryClient.getServices(); for(String
		  service:servicesList) { System.out.println("service:"+servicesList); 
		  }
		 
	}
	
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@PostMapping(value="/fileUpload",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String handleFileUpload(@RequestPart("file") MultipartFile file) {
		return file.getName();
		
	}

}
