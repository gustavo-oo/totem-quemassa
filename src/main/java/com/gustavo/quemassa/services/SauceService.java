package com.gustavo.quemassa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.quemassa.domain.Sauce;
import com.gustavo.quemassa.repositories.SauceRepository;

@Service
public class SauceService {
	
	@Autowired
	SauceRepository sauceRepository;

	public Sauce find(Integer id) {
		Optional<Sauce> sauce = sauceRepository.findById(id);
		
		return sauce.orElse(null);
	}
	
	public List<Sauce> findAll() {
		List<Sauce> sauces = sauceRepository.findAll();
		
		return sauces;
	}

}
