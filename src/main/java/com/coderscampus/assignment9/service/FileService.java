package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	
	private String fileName;
	
	public FileService () {
//		 this is just a blank no arg constructor because we also
//		 have a 1-arg constructor explicitly defined (below)
	}
	
	public FileService (String fileName) {
		this.fileName = fileName;
	}
	
	public void parseFile (String fileName) throws IOException {
		Reader in = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
		for (CSVRecord record : records) {
			record.get(0);
			record.get(1);
		}
	}
	
	public List<String> readFile () throws IOException {
		return Files.readAllLines(Paths.get(fileName));	
	}
	
	
}
