package com.gustavo.quemassa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavo.quemassa.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
		
	@Query(value = "select * from order_table where end_time  > now()", nativeQuery = true)
	List<Order> findActiveOrders();
}

