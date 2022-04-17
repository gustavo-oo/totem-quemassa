package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.DrinkOrder;

@Repository
public interface DrinkOrderRepository extends JpaRepository<DrinkOrder, Integer>{
	
}
