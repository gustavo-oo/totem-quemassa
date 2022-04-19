package com.gustavo.quemassa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Drink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Integer millimeters;
	
	private Double price;
	
	@OneToMany(mappedBy = "drink")
	private List<DrinkOrder> drinkOrders = new ArrayList<>();

	public Drink() {
	}

	public Drink(Integer id, String name, Integer millimeters, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.millimeters = millimeters;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public List<DrinkOrder> getDrinkOrders() {
		return drinkOrders;
	}

	public void setDrinkOrders(List<DrinkOrder> drinkOrders) {
		this.drinkOrders = drinkOrders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMillimeters() {
		return millimeters;
	}

	public void setMillimeters(Integer millimeters) {
		this.millimeters = millimeters;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", millimeters=" + millimeters + ", price=" + price
				+ ", drinkOrders=" + drinkOrders + "]";
	}
	
	
}
