package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Drink;
import com.gustavo.quemassa.services.DrinkService;

@RestController
@RequestMapping(value = "/drinks")
public class DrinkResource {
	
	@Autowired
	DrinkService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Drink> find(@PathVariable Integer id){
		Drink drink = service.find(id);
		
		return ResponseEntity.ok().body(drink);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Drink>> findAll(){
		List<Drink> drinks = service.findAll();
		
		return ResponseEntity.ok().body(drinks);
		
	}
	
}
