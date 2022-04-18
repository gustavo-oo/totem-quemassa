package com.gustavo.quemassa.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Ingredient;
import com.gustavo.quemassa.domain.Meal;
import com.gustavo.quemassa.domain.MealIngredient;
import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.domain.Pasta;
import com.gustavo.quemassa.domain.Sauce;
import com.gustavo.quemassa.domain.Topping;
import com.gustavo.quemassa.dto.NewMealDTO;
import com.gustavo.quemassa.repositories.MealRepository;

@Service
public class MealService {

	@Autowired
	MealRepository mealRepository;

	public Meal find(Integer id) {
		Optional<Meal> meal = mealRepository.findById(id);

		return meal.orElse(null);
	}

	public Meal fromDTO(NewMealDTO mealDTO, Order order) {
		Pasta pasta = new Pasta(mealDTO.getPastaId(), null, null);
		
		Set<Ingredient> ingredients = mealDTO.getIngredientsId().stream()
				.map(ingredientId -> new Ingredient(ingredientId, null, 0, null, null)).collect(Collectors.toSet());
				
		
		Sauce sauce = new Sauce(mealDTO.getSauceId(), null, 0, null, null);
		Topping topping = new Topping(mealDTO.getToppingId(), null, 0, null, null);
		
		Meal meal = new Meal(null, pasta, sauce, topping, order);
		
		Set<MealIngredient> mealIngredients = ingredients.stream()
				.map(ingredient -> new MealIngredient(meal, ingredient)).collect(Collectors.toSet());
		
		
		meal.setMealIngredients(mealIngredients);
		
		return meal;
	}

}
