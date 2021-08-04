package com.favouriterecipes.favourite.recipes.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.favouriterecipes.favourite.recipes.converter.LocalDateTimeConverter;


@Entity
@Table(name="RECIPES_TBL")
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recipesId", updatable = false, nullable = false)
	private Long recipesId;

	@Column(length = 100)
	private String recipesName;

	private String recipesType;

	private Integer noOfPerson;

	private String cookingInstruction;
	
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime preparedAt;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="RECIPESID_FK")
	private Set<UsedIngredients> usedingredients = new HashSet<>();

	public String getCookingInstruction() {
		return cookingInstruction;
	}

	public void setCookingInstruction(String cookingInstruction) {
		this.cookingInstruction = cookingInstruction;
	}

	public Integer getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(Integer noOfPerson) {
		this.noOfPerson = noOfPerson;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getRecipesId() {
		return recipesId;
	}

	public void setRecipesId(Long recipesId) {
		this.recipesId = recipesId;
	}

	public String getRecipesName() {
		return recipesName;
	}

	public void setRecipesName(String recipesName) {
		this.recipesName = recipesName;
	}

	public String getRecipesType() {
		return recipesType;
	}

	public void setRecipesType(String recipesType) {
		this.recipesType = recipesType;
	}

	public Set<UsedIngredients> getUsedingredients() {
		return usedingredients;
	}

	public void setUsedingredients(Set<UsedIngredients> usedingredients) {
		this.usedingredients = usedingredients;
	}

	public LocalDateTime getPreparedAt() {
		return preparedAt;
	}

	public void setPreparedAt(LocalDateTime preparedAt) {
		this.preparedAt = preparedAt;
	}

}
