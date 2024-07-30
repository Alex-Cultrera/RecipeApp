package com.coderscampus.assignment9.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	
	@GetMapping("/all-recipes")
	public List<String> readLines () throws IOException {
		System.out.println(user);
		return fileService.readFile();
	}
	
}
