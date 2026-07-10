package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OrderService;
import com.example.demo.entity.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {
 
	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping
	public Order create(@RequestBody Order order) {
		return service.save(order);
	}

	@GetMapping
	public List<Order> getAll() {
		return service.getAll();
	}
}