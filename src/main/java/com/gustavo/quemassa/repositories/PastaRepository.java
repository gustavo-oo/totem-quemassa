package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Pasta;

@Repository
public interface PastaRepository extends JpaRepository<Pasta, Integer>{
	
}
