package com.gustavo.quemassa.dto;

import java.io.Serializable;
import java.util.Set;

public class NewMealDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer pastaId;
	private Set<Integer> ingredientsId;
	private Integer sauceId;
	private Integer toppingId;
	
	public NewMealDTO() {
	}

	public NewMealDTO(Integer pastaId, Set<Integer> ingredientsId, Integer sauceId, Integer toppingId) {
		super();
		this.pastaId = pastaId;
		this.ingredientsId = ingredientsId;
		this.sauceId = sauceId;
		this.toppingId = toppingId;
	}

	public Integer getPastaId() {
		return pastaId;
	}

	public void setPastaId(Integer pastaId) {
		this.pastaId = pastaId;
	}

	public Set<Integer> getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(Set<Integer> ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public Integer getSauceId() {
		return sauceId;
	}

	public void setSauceId(Integer sauceId) {
		this.sauceId = sauceId;
	}

	public Integer getToppingId() {
		return toppingId;
	}

	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}
}
