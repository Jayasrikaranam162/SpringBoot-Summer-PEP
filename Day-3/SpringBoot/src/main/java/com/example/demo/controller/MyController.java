package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.MyServices;


@RestController
public class MyController {

    @Autowired
    private MyServices service;

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

    @GetMapping("/getAllEmployee/{id}")
    public Employee getAllEmployeebyID(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return service.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    @DeleteMapping("/deleteAllEmployee")
    public String deleteAllEmployee() {
        return service.deleteAllEmployees();
    }
}