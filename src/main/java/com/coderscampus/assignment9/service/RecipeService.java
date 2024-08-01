package com.coderscampus.assignment9.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;

@Service
public class RecipeService {

	private final List<Recipe> recipeList = new ArrayList<>();
	
	public void addRecipes(List<Recipe> recipes) {
		recipeList.addAll(recipes);
	}
	
	public List<Recipe> getAllRecipes() throws IOException {
		return recipeList;
	}
	
//	return new ArrayList<>(recipeList);
	
	
}
