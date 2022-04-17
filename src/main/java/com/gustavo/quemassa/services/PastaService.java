package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Pasta;
import com.gustavo.quemassa.repositories.PastaRepository;

@Service
public class PastaService {
	
	@Autowired
	PastaRepository pastaRepository;

	public Pasta find(Integer id) {
		Optional<Pasta> pasta = pastaRepository.findById(id);
		
		return pasta.orElse(null);
	}
	
	public List<Pasta> findAll() {
		List<Pasta> pastas = pastaRepository.findAll();
		
		return pastas;
	}

}
