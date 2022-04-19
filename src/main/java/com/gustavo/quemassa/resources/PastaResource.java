package com.gustavo.quemassa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.quemassa.domain.Pasta;
import com.gustavo.quemassa.services.PastaService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/pastas")
public class PastaResource {
	
	@Autowired
	PastaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pasta> find(@PathVariable Integer id){
		Pasta pasta = service.find(id);
		
		return ResponseEntity.ok().body(pasta);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Pasta>> findAll(){
		List<Pasta> pastas = service.findAll();
		
		return ResponseEntity.ok().body(pastas);
		
	}
	
}
