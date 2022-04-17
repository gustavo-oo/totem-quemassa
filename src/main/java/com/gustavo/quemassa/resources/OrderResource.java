package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	OrderService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> find(@PathVariable Integer id){
		Order order = service.find(id);
		
		return ResponseEntity.ok().body(order);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders = service.findAll();
		
		return ResponseEntity.ok().body(orders);
		
	}	
}
