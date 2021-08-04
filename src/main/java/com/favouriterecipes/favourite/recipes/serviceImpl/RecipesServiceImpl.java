package com.favouriterecipes.favourite.recipes.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.favouriterecipes.favourite.recipes.controller.IngredientController;
import com.favouriterecipes.favourite.recipes.entity.Ingredients;
import com.favouriterecipes.favourite.recipes.entity.Recipes;
import com.favouriterecipes.favourite.recipes.repository.IngredientRepository;
import com.favouriterecipes.favourite.recipes.repository.RecipesRepository;
import com.favouriterecipes.favourite.recipes.service.RecipesService;

@Service
public class RecipesServiceImpl implements RecipesService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);
	
	@Autowired
	private RecipesRepository repository; 
	
	public List<Recipes> fetchRecipes() {
		return repository.findAll();
	}
	
	public String saveRecipes(Recipes recipes) {
		
		Recipes oldRecipes = repository.findByRecipesName(recipes.getRecipesName());
		
		if (oldRecipes != null && oldRecipes.getRecipesId() != 0) {
			return "Con not add, Recipes is already exist";
		} else {
			
			recipes.setPreparedAt(LocalDateTime.now());
			recipes.setUpdatedAt(LocalDateTime.now());
			
			repository.save(recipes);
			return "Recipe is saved successfully";
		}
	}
	
	public String deleteRecipes(Long recipesId) {
		
		String message = "Recipe does not exists, can not be deleted";
		
		if (repository.existsById(recipesId)) {
			repository.deleteById(recipesId);
			message = "Recipe is deleted successfully";
		}
		return message;
	}
	
	public void deleteAllRecipes() {
		repository.deleteAll();
	}
	
	public String  updateRecipes(Recipes recipes) {
		
		if (repository.existsById(recipes.getRecipesId())) {
			repository.save(recipes);
		}
		
		return "Recipe is updated successfully";
	}
}
