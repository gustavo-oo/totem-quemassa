package com.gustavo.quemassa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.quemassa.domain.Order;
import com.gustavo.quemassa.dto.ActiveOrderDTO;
import com.gustavo.quemassa.dto.NewOrderDTO;
import com.gustavo.quemassa.services.OrderService;

@CrossOrigin(exposedHeaders = "*")
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	OrderService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> find(@PathVariable Integer id) {
		Order order = service.find(id);

		return ResponseEntity.ok().body(order);

	}

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = service.findAll();

		return ResponseEntity.ok().body(orders);

	}

	@GetMapping(value = "/active")
	public ResponseEntity<List<ActiveOrderDTO>> findActiveOrders() {
		List<Order> orders = service.findActiveOrders();

		List<ActiveOrderDTO> orderDTO = service.toDTO(orders);

		return ResponseEntity.ok().body(orderDTO);
	}

	@GetMapping(value = "/history")
	public ResponseEntity<List<ActiveOrderDTO>> findHistoryOrders() {
		List<Order> orders = service.findAll();

		List<ActiveOrderDTO> orderDTO = service.toDTO(orders);

		return ResponseEntity.ok().body(orderDTO);
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody NewOrderDTO newOrderDTO){
		
		Order newOrder = service.fromDTO(newOrderDTO);
		newOrder = service.create(newOrder);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newOrder.getId())
					.toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("orderId", String.valueOf(newOrder.getId()));
		headers.add("totalPrice", String.valueOf(newOrder.getTotalPrice()));
		
		return ResponseEntity.created(uri).headers(headers).build();
	}
}
