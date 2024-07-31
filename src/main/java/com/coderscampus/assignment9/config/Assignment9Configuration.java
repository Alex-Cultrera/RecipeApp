package com.coderscampus.assignment9.config;

import org.springframework.context.annotation.Bean;

import com.coderscampus.assignment9.service.FileService;


public class Assignment9Configuration {

	
	@Bean
	public FileService fileService () {
		return new FileService("test.txt");
	}
	
}
