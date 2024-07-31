package com.coderscampus.assignment9.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;
	
	@GetMapping("/all-recipes")
	public Iterable<CSVRecord> allRecipes () throws IOException {
		return fileService.parseFile();
	}
	
}
