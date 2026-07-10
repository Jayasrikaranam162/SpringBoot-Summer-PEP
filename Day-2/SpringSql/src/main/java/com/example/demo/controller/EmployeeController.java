package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // CREATE
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // READ ALL
    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    // READ BY ID
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                   @RequestBody Employee employee) {

        return service.updateEmployee(id, employee);
    }

    // DELETE
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}