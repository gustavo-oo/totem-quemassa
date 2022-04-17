package com.gustavo.quemassa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Sauce;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer>{
}

