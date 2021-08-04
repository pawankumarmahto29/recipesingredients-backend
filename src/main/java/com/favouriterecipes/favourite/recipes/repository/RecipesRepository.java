package com.favouriterecipes.favourite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favouriterecipes.favourite.recipes.entity.Recipes;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {

	Recipes findByRecipesName(String recipesName);
}
