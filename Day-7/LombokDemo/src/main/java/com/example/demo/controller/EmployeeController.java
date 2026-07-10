package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    // CREATE
    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return service.save(employee);
    }

    // READ ALL
    @GetMapping("/display")
    public List<Employee> display(){
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/display/{id}")
    public Employee displayById(@PathVariable Integer id){
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Integer id,
                           @RequestBody Employee employee){
        return service.update(id, employee);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }
}