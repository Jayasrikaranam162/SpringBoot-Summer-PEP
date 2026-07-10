package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repository;

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public Order save(Order order) {
		return repository.save(order);
	}

	public List<Order> getAll() {
		return repository.findAll();
	}

}
