package com.favouriterecipes.favourite.recipes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.favouriterecipes.favourite.recipes.entity.Ingredients;
import com.favouriterecipes.favourite.recipes.service.IngredientService;


@RestController
@RequestMapping(value="/ingredient")
public class IngredientController {
	
	//private static final Logger logger = org.slf4j.LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private IngredientService ingredientService;
	
	
	@RequestMapping(value = "/fetchIngredients", method = RequestMethod.GET)
	public List<Ingredients> fetchIngredients() {
		List<Ingredients> ingredientList = ingredientService.fetchIngredients();
		return ingredientList;
	}

	@RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
	public Ingredients addIngredient(@RequestBody Ingredients ingredient) {
		return ingredientService.saveIngredient(ingredient);
	}
	
	@RequestMapping(value = "/deleteIngredient/{id}", method = RequestMethod.DELETE)
	public String deleteIngredient(@PathVariable("id") Long ingredientId) {
		 ingredientService.deleteIngredient(ingredientId);
		 return "Ingredient Deleted Successfully";
	}
	
}
