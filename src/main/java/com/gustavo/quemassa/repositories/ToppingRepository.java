package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer>{
}

