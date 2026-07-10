package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RaiseSalaryRequest;
import com.example.demo.entity.Employee;
import com.example.demo.repo.MyRepo;

@RestController
public class EmployeeController {

    @Autowired
    MyRepo repo;

    // ================= CREATE EMPLOYEE =================

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee emp) {

        // Name Validation
        if (!emp.getName().matches("^[A-Za-z]+( [A-Za-z]+){0,2}$")) {
            return "Invalid Name! Only alphabets and maximum 2 spaces are allowed.";
        }

        // Age Validation
        if (emp.getAge() < 18 || emp.getAge() > 60) {
            return "Age should be between 18 and 60.";
        }

        // Designation Validation + Salary

        if (emp.getDesignation().equalsIgnoreCase("Programmer")) {

            emp.setSalary(25000);

        } else if (emp.getDesignation().equalsIgnoreCase("Manager")) {

            emp.setSalary(30000);

        } else if (emp.getDesignation().equalsIgnoreCase("Tester")) {

            emp.setSalary(20000);

        } else {

            return "Invalid Designation.";

        }

        repo.save(emp);

        return "Employee Saved Successfully.";

    }

    // ================= DISPLAY =================

    @GetMapping("/display")
    public List<Employee> displayEmployee() {

        return repo.findAll();

    }

    // ================= RAISE SALARY =================

    @PutMapping("/raiseSalary")
    public String raiseSalary(@RequestBody RaiseSalaryRequest request) {

        if (request.getPercentage() < 1 || request.getPercentage() > 10) {

            return "Percentage should be between 1 and 10.";

        }

        List<Employee> employees =
                repo.findByNameIgnoreCase(request.getName());

        if (employees.isEmpty()) {

            return "Employee Not Found.";

        }

        for (Employee emp : employees) {

            double newSalary =
                    emp.getSalary()
                            + (emp.getSalary()
                            * request.getPercentage() / 100);

            emp.setSalary(newSalary);

            repo.save(emp);

        }

        return "Salary Updated Successfully.";

    }

}