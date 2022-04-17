package com.gustavo.quemassa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sauce implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	private Boolean vegan;
	private Boolean lactose;

	public Sauce() {
	}

	public Sauce(Integer id, String name, double price, Boolean vegan, Boolean lactose) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vegan = vegan;
		this.lactose = lactose;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getVegan() {
		return vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}

	public Boolean getLactose() {
		return lactose;
	}

	public void setLactose(Boolean lactose) {
		this.lactose = lactose;
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
		Sauce other = (Sauce) obj;
		return Objects.equals(id, other.id);
	}
}
