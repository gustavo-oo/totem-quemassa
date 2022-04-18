package com.gustavo.quemassa.dto;

import java.io.Serializable;

public class NewDrinkOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer drinkId;
	private Integer quantity;
	
	public NewDrinkOrderDTO() {
	}

	public NewDrinkOrderDTO(Integer drink, Integer quantity) {
		super();
		this.drinkId = drink;
		this.quantity = quantity;
	}

	public Integer getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(Integer drink) {
		this.drinkId = drink;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
