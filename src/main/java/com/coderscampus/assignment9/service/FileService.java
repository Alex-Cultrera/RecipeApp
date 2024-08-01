package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;

@Service
public class FileService {
	
	public List<Recipe> importRecipesFromCSV (String fileName) throws IOException {
		
		List<Recipe> recipes = new ArrayList<>();
		
		Reader in = new FileReader(fileName);
		
		Iterable<CSVRecord> records = CSVFormat.RFC4180.builder()
		  .setHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
		  .build()
		  .parse(in);
		
		if (records != null) {
		
			for (CSVRecord record : records) {
			    
			    Recipe recipe = new Recipe();
				recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
				recipe.setDairyFree(Boolean.getBoolean(record.get("Dairy Free")));
				recipe.setGlutenFree(Boolean.getBoolean(record.get("Gluten Free")));
				recipe.setInstructions(record.get("Instructions"));
				recipe.setPreparationMinutes(Double.valueOf(record.get("Preparation Minutes")));
				recipe.setPricePerServing(Double.valueOf(record.get("Price Per Serving")));
				recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
				recipe.setServings(Integer.parseInt(record.get("Servings")));
				recipe.setSpoonacularScore(Double.valueOf(record.get("Spoonacular Score")));
				recipe.setTitle(record.get("Title"));
				recipe.setVegan(Boolean.valueOf(record.get("Vegan")));
				recipe.setVegetarian(Boolean.valueOf(record.get("Vegetarian")));
				
				recipes.add(recipe);
			}
		
		} else {
			System.out.println("No records found.");
		}
		
		return recipes;
	}

			
}
	
	
//	public List<Recipe> importRecipesFromCSV (String fileName) throws IOException {
//		List<Recipe> recipes = new ArrayList<>();
//		
//		try (Reader inboundData = new FileReader(fileName);
//				CSVParser csvParser = new CSVParser(inboundData, CSVFormat.DEFAULT)) {
//			List<CSVRecord> records = csvParser.getRecords();
//			
//			if(!records.isEmpty()) {
//				
//				for (int i = 1; i < records.size(); i++) {
//					CSVRecord record = records.get(i);
//					Recipe recipe = new Recipe();
//					recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
//					recipe.setDairyFree(Boolean.getBoolean(record.get(1)));
//					recipe.setGlutenFree(Boolean.getBoolean(record.get(2)));
//					recipe.setInstructions(record.get(3));
//					recipe.setPreparationMinutes(Double.valueOf(record.get(4)));
//					recipe.setPricePerServing(Double.valueOf(record.get(5)));
//					recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
//					recipe.setServings(Integer.parseInt(record.get(7)));
//					recipe.setSpoonacularScore(Double.valueOf(record.get(8)));
//					recipe.setTitle(record.get(9));
//					recipe.setVegan(Boolean.valueOf(record.get(10)));
//					recipe.setVegetarian(Boolean.valueOf(record.get(11)));
//					
//					recipes.add(recipe);
//				}
//				
//			} else {
//				System.out.println("No records found.");
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		return recipes;
//	}

	

//	public List<Recipe> importRecipesFromCSV (String fileName) throws IOException {
//		
//		List<Recipe> recipes = new ArrayList<>();
//		
//		Reader inboundData = new FileReader(fileName);
//		List<String> records = inboundData.read;
//			
//			if((List<String>)records != null) {
//				
//				for (CSVRecord record : records) {
//					Recipe recipe = new Recipe();
//					recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
//					recipe.setDairyFree(Boolean.getBoolean(record.get(1)));
//					recipe.setGlutenFree(Boolean.getBoolean(record.get(2)));
//					recipe.setInstructions(record.get(3));
//					recipe.setPreparationMinutes(Double.valueOf(record.get(4)));
//					recipe.setPricePerServing(Double.valueOf(record.get(5)));
//					recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
//					recipe.setServings(Integer.parseInt(record.get(7)));
//					recipe.setSpoonacularScore(Double.valueOf(record.get(8)));
//					recipe.setTitle(record.get(9));
//					recipe.setVegan(Boolean.valueOf(record.get(10)));
//					recipe.setVegetarian(Boolean.valueOf(record.get(11)));
//					
//					recipes.add(recipe);
//				}
//				
//			} else {
//				System.out.println("No records found.");
//			}
//		
//		return recipes;
//	}
//				
//				