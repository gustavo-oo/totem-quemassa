package com.gustavo.quemassa.services;

import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Drink;
import com.gustavo.quemassa.domain.DrinkOrder;
import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.dto.NewDrinkOrderDTO;

@Service
public class DrinkOrderService {
	
	public DrinkOrder fromDTO(NewDrinkOrderDTO drinkOrderDTO, Order order) {
		Drink drink = new Drink(drinkOrderDTO.getDrinkId(), null, null, null);
		DrinkOrder drinkOrder = new DrinkOrder(null, order, drink, drinkOrderDTO.getQuantity());
		
		return drinkOrder;
	}

}