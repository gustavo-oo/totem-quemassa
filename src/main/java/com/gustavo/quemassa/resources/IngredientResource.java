package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Ingredient;
import com.gustavo.quemassa.services.IngredientService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/ingredients")
public class IngredientResource {
	
	@Autowired
	IngredientService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ingredient> find(@PathVariable Integer id){
		Ingredient ingredient = service.find(id);
		
		return ResponseEntity.ok().body(ingredient);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Ingredient>> findAll(){
		List<Ingredient> ingredients = service.findAll();
		
		return ResponseEntity.ok().body(ingredients);
		
	}
	
}
