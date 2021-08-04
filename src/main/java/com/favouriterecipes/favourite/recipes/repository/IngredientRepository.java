package com.favouriterecipes.favourite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favouriterecipes.favourite.recipes.entity.Ingredients;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long>{

}
