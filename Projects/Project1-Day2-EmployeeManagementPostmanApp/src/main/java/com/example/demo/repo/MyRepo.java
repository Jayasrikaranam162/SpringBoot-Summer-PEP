package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface MyRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByNameIgnoreCase(String name);

}