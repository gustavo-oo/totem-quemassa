package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.quemassa.domain.DrinkOrder;
import com.gustavo.quemassa.domain.Meal;
import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.dto.ActiveOrderDTO;
import com.gustavo.quemassa.dto.NewOrderDTO;
import com.gustavo.quemassa.repositories.DrinkOrderRepository;
import com.gustavo.quemassa.repositories.MealIngredientRepository;
import com.gustavo.quemassa.repositories.MealRepository;
import com.gustavo.quemassa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	DrinkOrderService drinkOrderService;

	@Autowired
	MealRepository mealRepository;

	@Autowired
	MealIngredientRepository mealIngredientRepository;

	@Autowired
	DrinkOrderRepository drinkOrderRepository;

	@Autowired
	MealService mealService;

	public Order find(Integer id) {
		Optional<Order> order = orderRepository.findById(id);

		return order.orElse(null);
	}

	public List<Order> findAll() {
		List<Order> orders = orderRepository.findAll();

		return orders;
	}

	@Transactional
	public Order create(Order newOrder) {
		Order savedOrder = orderRepository.save(newOrder);
						
		mealRepository.saveAll(newOrder.getMeals());
		
		newOrder.getMeals().forEach(meal -> mealIngredientRepository.saveAll(meal.getMealIngredients()));
		
		drinkOrderRepository.saveAll(newOrder.getDrinkOrders());
		
		return savedOrder;
	}

	public Order fromDTO(NewOrderDTO newOrder) {
		Order order = new Order(null, newOrder.getClientName());

		List<Meal> meals = newOrder.getMeals().stream().map(mealDTO -> mealService.fromDTO(mealDTO, order))
				.collect(Collectors.toList());

		List<DrinkOrder> drinkOrders = newOrder.getDrinkOrders().stream()
				.map(drinkOrderDTO -> drinkOrderService.fromDTO(drinkOrderDTO, order)).collect(Collectors.toList());

		order.setMeals(meals);

		order.getDrinkOrders().addAll(drinkOrders);

		return order;
	}
	
	public ActiveOrderDTO toDTO(Order order) {
		ActiveOrderDTO activeOrder = new ActiveOrderDTO(order.getId(), order.getClientName(), order.getEndTime());
		activeOrder.setTotalPrice(order.getTotalPrice());
		
		return activeOrder;
	}
	
	public List<ActiveOrderDTO> toDTO(List<Order> orders){
		return orders.stream().map(order -> toDTO(order)).collect(Collectors.toList());
	}

	public List<Order> findActiveOrders() {
		return orderRepository.findActiveOrders();
	}
}
