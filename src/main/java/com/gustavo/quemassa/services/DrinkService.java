package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Drink;
import com.gustavo.quemassa.repositories.DrinkRepository;

@Service
public class DrinkService {
	
	@Autowired
	DrinkRepository drinkRepository;

	public Drink find(Integer id) {
		Optional<Drink> drink = drinkRepository.findById(id);
		
		return drink.orElse(null);
	}
	
	public List<Drink> findAll() {
		List<Drink> drinks = drinkRepository.findAll();
		
		return drinks;
	}

}
