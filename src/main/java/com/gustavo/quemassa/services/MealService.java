package com.gustavo.quemassa.services;

import java.util.List;
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
import com.gustavo.quemassa.repositories.IngredientRepository;
import com.gustavo.quemassa.repositories.MealRepository;
import com.gustavo.quemassa.repositories.PastaRepository;
import com.gustavo.quemassa.repositories.SauceRepository;
import com.gustavo.quemassa.repositories.ToppingRepository;

@Service
public class MealService {

	@Autowired
	MealRepository mealRepository;

	@Autowired
	PastaRepository pastaRepository;

	@Autowired
	IngredientRepository ingredientRepository;

	@Autowired
	SauceRepository sauceRepository;

	@Autowired
	ToppingRepository toppingRepository;

	public Meal find(Integer id) {
		Optional<Meal> meal = mealRepository.findById(id);

		return meal.orElse(null);
	}

	public Meal fromDTO(NewMealDTO mealDTO, Order order) {

		Optional<Pasta> pasta = mealDTO.getPastaId() != null ? pastaRepository.findById(mealDTO.getPastaId()) : Optional.empty();

		List<Ingredient> ingredients = mealDTO.getIngredientsId() != null
				? ingredientRepository.findAllById(mealDTO.getIngredientsId())
				: null;

		Optional<Sauce> sauce = mealDTO.getSauceId() != null ? sauceRepository.findById(mealDTO.getSauceId()) : Optional.empty();

		Optional<Topping> topping = mealDTO.getToppingId() != null ? toppingRepository.findById(mealDTO.getToppingId()) : Optional.empty();

		Meal meal = new Meal(null, pasta.orElse(null), sauce.orElse(null), topping.orElse(null), order);

		Set<MealIngredient> mealIngredients = ingredients.stream()
				.map(ingredient -> new MealIngredient(meal, ingredient)).collect(Collectors.toSet());

		meal.setMealIngredients(mealIngredients);

		return meal;
	}

}
