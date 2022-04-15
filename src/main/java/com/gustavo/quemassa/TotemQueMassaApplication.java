package com.gustavo.quemassa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.quemassa.domain.Ingredient;
import com.gustavo.quemassa.repositories.IngredientRepository;

@SpringBootApplication
public class TotemQueMassaApplication implements CommandLineRunner{
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TotemQueMassaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Ingredient ingredient1 = new Ingredient(null, "Bacon", 3.00, false, false);
		ingredientRepository.saveAll(Arrays.asList(ingredient1));
		
	}
}
