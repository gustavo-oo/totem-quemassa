package com.gustavo.quemassa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Meal;
import com.gustavo.quemassa.services.MealService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/meals")
public class MealResource {
	
	@Autowired
	MealService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Meal> find(@PathVariable Integer id){
		Meal meal = service.find(id);
		
		return ResponseEntity.ok().body(meal);
		
	}
	
}
