package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Topping;
import com.gustavo.quemassa.repositories.ToppingRepository;

@Service
public class ToppingService {
	
	@Autowired
	ToppingRepository toppingRepository;

	public Topping find(Integer id) {
		Optional<Topping> topping = toppingRepository.findById(id);
		
		return topping.orElse(null);
	}
	
	public List<Topping> findAll() {
		List<Topping> toppings = toppingRepository.findAll();
		
		return toppings;
	}

}
