package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer>{
}

