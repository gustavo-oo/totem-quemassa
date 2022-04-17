package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	public Order find(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		
		return order.orElse(null);
	}
	
	public List<Order> findAll() {
		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}

}
