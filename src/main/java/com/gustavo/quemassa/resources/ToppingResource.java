package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Topping;
import com.gustavo.quemassa.services.ToppingService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/toppings")
public class ToppingResource {
	
	@Autowired
	ToppingService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Topping> find(@PathVariable Integer id){
		Topping topping = service.find(id);
		
		return ResponseEntity.ok().body(topping);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Topping>> findAll(){
		List<Topping> toppings = service.findAll();
		
		return ResponseEntity.ok().body(toppings);
		
	}
	
}
