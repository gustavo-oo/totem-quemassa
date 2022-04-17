package com.gustavo.quemassa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class MealIngredientsPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "meal_id")
	private Meal meal;

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredient, meal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealIngredientsPK other = (MealIngredientsPK) obj;
		return Objects.equals(ingredient, other.ingredient) && Objects.equals(meal, other.meal);
	}
}
