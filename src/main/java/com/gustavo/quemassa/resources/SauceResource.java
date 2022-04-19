package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Sauce;
import com.gustavo.quemassa.services.SauceService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/sauces")
public class SauceResource {
	
	@Autowired
	SauceService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sauce> find(@PathVariable Integer id){
		Sauce sauce = service.find(id);
		
		return ResponseEntity.ok().body(sauce);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Sauce>> findAll(){
		List<Sauce> sauces = service.findAll();
		
		return ResponseEntity.ok().body(sauces);
		
	}
	
}
