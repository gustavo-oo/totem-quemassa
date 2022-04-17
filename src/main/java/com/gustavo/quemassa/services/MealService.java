package com.gustavo.quemassa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Meal;
import com.gustavo.quemassa.repositories.MealRepository;

@Service
public class MealService {
	
	@Autowired
	MealRepository mealRepository;

	public Meal find(Integer id) {
		Optional<Meal> meal = mealRepository.findById(id);
		
		return meal.orElse(null);
	}

}
