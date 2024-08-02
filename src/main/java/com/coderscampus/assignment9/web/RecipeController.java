package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/all-recipes")
	public List<Recipe> getRecipes() throws IOException {
		return recipeService.getAllRecipes();
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFreeRecipes() throws IOException {
		List<Recipe> glutenFree;
		glutenFree = recipeService.getAllRecipes().stream()
												  .filter(recipe -> recipe.getGlutenFree().equals(true))
												  .collect(Collectors.toList());
		return glutenFree;
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVeganRecipes() throws IOException {
		List<Recipe> vegan;
		vegan = recipeService.getAllRecipes().stream()
												  .filter(recipe -> recipe.getVegan().equals(true))
												  .collect(Collectors.toList());
		return vegan;
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFreeRecipes() throws IOException {
		List<Recipe> veganAndGlutenFree;
		veganAndGlutenFree = recipeService.getAllRecipes().stream()
												  .filter(recipe -> recipe.getVegan().equals(true))
												  .filter(recipe -> recipe.getGlutenFree().equals(true))
												  .collect(Collectors.toList());
		return veganAndGlutenFree;
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarianRecipes() throws IOException {
		List<Recipe> vegetarian;
		vegetarian = recipeService.getAllRecipes().stream()
												  .filter(recipe -> recipe.getVegetarian().equals(true))
												  .collect(Collectors.toList());
		return vegetarian;
	}
	
}
