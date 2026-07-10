package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.MyRepo;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    private MyRepo repository;

    // GET ALL
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/getAllEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }

    // ADD
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }
    
    //UPDATE
    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @RequestBody Employee employee) {

        Optional<Employee> emp = repository.findById(id);

        if(emp.isPresent()) {
            Employee existing = emp.get();

            existing.setName(employee.getName());
            existing.setSalary(employee.getSalary());

            repository.save(existing);

            return "Employee Updated Successfully";
        }

        return "Employee Not Found";
    }
    
    //DELETE
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {

        repository.deleteById(id);

        return "Employee Deleted Successfully";
    }

}