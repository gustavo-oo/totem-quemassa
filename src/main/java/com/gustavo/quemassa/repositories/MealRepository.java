package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer>{
	
}
