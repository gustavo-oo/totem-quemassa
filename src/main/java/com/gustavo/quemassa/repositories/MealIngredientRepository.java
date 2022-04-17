package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.MealIngredient;

@Repository
public interface MealIngredientRepository extends JpaRepository<MealIngredient, Integer>{
}

