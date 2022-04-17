package com.gustavo.quemassa;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.quemassa.domain.Drink;
import com.gustavo.quemassa.domain.DrinkOrder;
import com.gustavo.quemassa.domain.Ingredient;
import com.gustavo.quemassa.domain.Meal;
import com.gustavo.quemassa.domain.MealIngredient;
import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.domain.Pasta;
import com.gustavo.quemassa.domain.Sauce;
import com.gustavo.quemassa.domain.Topping;
import com.gustavo.quemassa.repositories.DrinkOrderRepository;
import com.gustavo.quemassa.repositories.DrinkRepository;
import com.gustavo.quemassa.repositories.IngredientRepository;
import com.gustavo.quemassa.repositories.MealIngredientRepository;
import com.gustavo.quemassa.repositories.MealRepository;
import com.gustavo.quemassa.repositories.OrderRepository;
import com.gustavo.quemassa.repositories.PastaRepository;
import com.gustavo.quemassa.repositories.SauceRepository;
import com.gustavo.quemassa.repositories.ToppingRepository;

@SpringBootApplication
public class TotemQueMassaApplication implements CommandLineRunner{
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	PastaRepository pastaRepository;
	
	@Autowired
	MealRepository mealRepository;
	
	@Autowired
	SauceRepository sauceRepository;
	
	@Autowired
	ToppingRepository toppingRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	MealIngredientRepository mealIngredientRepository;
	
	@Autowired
	DrinkOrderRepository drinkOrderRepository;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static void main(String[] args) {
		SpringApplication.run(TotemQueMassaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Ingredient ingredient1 = new Ingredient(null, "Bacon", 3.00, false, false);
		Ingredient ingredient2 = new Ingredient(null, "Brócolis", 1.50, true, false);
		Ingredient ingredient3 = new Ingredient(null, "Mussarela", 2.00, false, true);
		
		ingredientRepository.saveAll(Arrays.asList(ingredient1, ingredient2, ingredient3));
		
		Pasta pasta1 = new Pasta(null, "Penne", 25.00);
		Pasta pasta2 = new Pasta(null, "Parafuso", 10.00);
		Pasta pasta3 = new Pasta(null, "Spaghetti", 20.00);
		
		pastaRepository.saveAll(Arrays.asList(pasta1, pasta2, pasta3));
		
		Sauce sauce1 = new Sauce(null, "Molho Branco", 8, false, true);
		Sauce sauce2 = new Sauce(null, "Molho Vermelho", 5, true, false);
		Sauce sauce3 = new Sauce(null, "Molho Misto", 7.50, false, true);
		
		sauceRepository.saveAll(Arrays.asList(sauce1, sauce2, sauce3));
		
		Topping topping1 = new Topping(null, "Parmesão", 2.50, false, true);
		
		toppingRepository.saveAll(Arrays.asList(topping1));
		
		Drink drink1 = new Drink(null, "Coca-cola", 350, 4.00);
		Drink drink2 = new Drink(null, "Água", 250, 2.00);
		
		Date startTime = dateFormat.parse("17/04/2022 15:30");
		Date endTime = dateFormat.parse("17/04/2022 15:45");
		Order order1 = new Order(null, "Gustavo", startTime, endTime);
		
		Meal meal1 = new Meal(null, pasta1, sauce1, topping1, order1);
		Meal meal2 = new Meal(null, pasta3, sauce3, null, order1);
		
		order1.setMeals(Arrays.asList(meal1, meal2));
		
		DrinkOrder drinkorder1 = new DrinkOrder(null, order1, drink1, 2);
		DrinkOrder drinkorder2 = new DrinkOrder(null, order1, drink1, 3);
		
		order1.setDrinkOrders(Arrays.asList(drinkorder1, drinkorder2));
		drink1.setDrinkOrders(Arrays.asList(drinkorder1));
		drink2.setDrinkOrders(Arrays.asList(drinkorder1));
		
		drinkRepository.saveAll(Arrays.asList(drink1, drink2));
		orderRepository.saveAll(Arrays.asList(order1));
		drinkOrderRepository.saveAll(Arrays.asList(drinkorder1, drinkorder2));
		
		mealRepository.saveAll(Arrays.asList(meal1, meal2));
		
		MealIngredient mealIngredient1 = new MealIngredient(meal1, ingredient1);
		MealIngredient mealIngredient2 = new MealIngredient(meal1, ingredient2);
		MealIngredient mealIngredient3 = new MealIngredient(meal2, ingredient3);
		
		ingredient1.getMealIngredients().addAll(Arrays.asList(mealIngredient1));
		ingredient2.getMealIngredients().addAll(Arrays.asList(mealIngredient1));
		ingredient3.getMealIngredients().addAll(Arrays.asList(mealIngredient3));
		
		meal1.getMealIngredients().addAll(Arrays.asList(mealIngredient1, mealIngredient2));
		meal2.getMealIngredients().addAll(Arrays.asList(mealIngredient3));
		
		mealIngredientRepository.saveAll(Arrays.asList(mealIngredient1, mealIngredient2, mealIngredient3));
	}
}
