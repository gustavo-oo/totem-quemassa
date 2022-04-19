package com.gustavo.quemassa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String clienteName;
	private List<NewDrinkOrderDTO> drinkOrders = new ArrayList<>();
	private List<NewMealDTO> meals = new ArrayList<>();
	
	public NewOrderDTO() {
	}

	public NewOrderDTO(String clienteName) {
		super();
		this.clienteName = clienteName;
	}

	public String getClientName() {
		return clienteName;
	}

	public void setClientName(String clienteName) {
		this.clienteName = clienteName;
	}

	public List<NewDrinkOrderDTO> getDrinkOrders() {
		return drinkOrders;
	}

	public void setDrinkOrders(List<NewDrinkOrderDTO> drinkOrders) {
		this.drinkOrders = drinkOrders;
	}

	public List<NewMealDTO> getMeals() {
		return meals;
	}

	public void setMeals(List<NewMealDTO> meals) {
		this.meals = meals;
	}
}
