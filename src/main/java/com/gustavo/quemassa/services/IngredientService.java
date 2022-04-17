package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Ingredient;
import com.gustavo.quemassa.repositories.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;

	public Ingredient find(Integer id) {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		
		return ingredient.orElse(null);
	}
	
	public List<Ingredient> findAll() {
		List<Ingredient> ingredients = ingredientRepository.findAll();
		
		return ingredients;
	}

}
