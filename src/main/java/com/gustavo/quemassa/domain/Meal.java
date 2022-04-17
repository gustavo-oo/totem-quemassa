package com.gustavo.quemassa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name = "pasta_id")
	private Pasta pasta;

	@OneToMany(mappedBy = "id.meal")
	private Set<MealIngredient> mealIngredients = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "sauce_id")
	private Sauce sauce;
	
	@ManyToOne
	@JoinColumn(name = "topping_id")
	private Topping topping;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Meal() {
	}

	public Meal(Integer id, Pasta pasta, Sauce sauce, Topping topping, Order order) {
		super();
		Id = id;
		this.pasta = pasta;
		this.sauce = sauce;
		this.topping = topping;
		this.order = order;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@JsonIgnore
	public Set<MealIngredient> getMealIngredients() {
		return mealIngredients;
	}
	
	public void setMealIngredients(Set<MealIngredient> mealIngredients) {
		this.mealIngredients = mealIngredients;
	}
	
	public List<Ingredient> getIngredients() {
		return mealIngredients.stream().map(mealIngredient -> mealIngredient.getIngredient()).collect(Collectors.toList());
	}
	
	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		return Objects.equals(Id, other.Id);
	}
}
