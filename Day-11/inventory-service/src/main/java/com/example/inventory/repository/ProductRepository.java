package com.example.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByProductName(String productName);

}