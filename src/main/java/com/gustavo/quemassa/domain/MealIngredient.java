package com.gustavo.quemassa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MealIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private MealIngredientsPK id = new MealIngredientsPK();

	public MealIngredient() {
	}

	public MealIngredient(Meal meal, Ingredient ingredient) {
		super();
		setIngredient(ingredient);
		setMeal(meal);
	}

	public Ingredient getIngredient() {
		return id.getIngredient();
	}

	public void setIngredient(Ingredient ingredient) {
		id.setIngredient(ingredient);
	}

	@JsonIgnore
	public Meal getMeal() {
		return id.getMeal();
	}

	public void setMeal(Meal meal) {
		id.setMeal(meal);
	}

	public MealIngredientsPK getId() {
		return id;
	}

	public void setId(MealIngredientsPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealIngredient other = (MealIngredient) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ingredient: " + getIngredient().getId() + " Meal: " + getMeal().getId();
	}
	
}
