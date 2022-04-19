package com.gustavo.quemassa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Drink;
import com.gustavo.quemassa.domain.DrinkOrder;
import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.dto.NewDrinkOrderDTO;
import com.gustavo.quemassa.repositories.DrinkRepository;

@Service
public class DrinkOrderService {
	@Autowired
	DrinkRepository drinkRepository;
	
	public DrinkOrder fromDTO(NewDrinkOrderDTO drinkOrderDTO, Order order) {
		Optional<Drink> drink = drinkRepository.findById(drinkOrderDTO.getDrinkId());
		DrinkOrder drinkOrder = new DrinkOrder(null, order, drink.orElse(null), drinkOrderDTO.getQuantity());
		return drinkOrder;
	}

}