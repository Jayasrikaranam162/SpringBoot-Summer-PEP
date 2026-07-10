package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setProductName(product.getProductName());
            existing.setQuantity(product.getQuantity());
            return repository.save(existing);
        }

        return null;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}