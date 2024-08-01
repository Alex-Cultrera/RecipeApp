package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;
import com.coderscampus.assignment9.service.RecipeService;

import jakarta.annotation.PostConstruct;

@RestController
public class RecipeController {

	private final RecipeService recipeService;
	private final FileService fileService;
	
	@Autowired
	private RecipeController(RecipeService recipeService, FileService fileService) {
		this.recipeService = recipeService;
		this.fileService = fileService;
	}
	
	@PostConstruct
	public void initialize() throws IOException {
		String fileName = "recipes.txt";
		List<Recipe> recipes = fileService.importRecipesFromCSV(fileName);
		recipeService.addRecipes(recipes);
	}
	
	@GetMapping("")
	public String sayHi() {
		return "Hi";
	}
	
	@GetMapping("/all-recipes")
	public List<Recipe> getRecipes() throws IOException {
		return recipeService.getAllRecipes();
	}
	
//	@GetMapping("/gluten-free")
//	@GetMapping("/vegan")
//	@GetMapping("/vegan-and-gluten-free")
//	@GetMapping("/vegetarian")
	
	
	
	
}
