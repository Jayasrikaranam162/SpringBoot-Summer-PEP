package com.example.demo.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.repo.MyRepo;

@Controller
public class EmployeeController {

    @Autowired
    MyRepo repo;

    // ---------------- HOME ----------------

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // ---------------- CREATE ----------------

    @GetMapping("/create-form")
    public String createForm() {
        return "create";
    }

    @PostMapping("/create")
    public String createEmployee(Employee emp, Model model) {

        String name = emp.getName().trim();

        // Alphabets + maximum 2 spaces
        String regex = "^[A-Za-z]+( [A-Za-z]+){0,2}$";

        if (!Pattern.matches(regex, name)) {
            model.addAttribute("message",
                    "Name should contain only alphabets and maximum 2 spaces.");
            return "create";
        }

        if (emp.getAge() < 18 || emp.getAge() > 60) {
            model.addAttribute("message",
                    "Age must be between 18 and 60.");
            return "create";
        }

        switch (emp.getDesignation()) {

        case "Programmer":
            emp.setSalary(25000);
            break;

        case "Manager":
            emp.setSalary(30000);
            break;

        case "Tester":
            emp.setSalary(20000);
            break;

        default:
            model.addAttribute("message",
                    "Invalid Designation.");
            return "create";

        }

        repo.save(emp);

        return "continue";
    }

    // ---------------- DISPLAY ----------------

    @GetMapping("/display")
    public String display(Model model) {

        model.addAttribute("employees", repo.findAll());

        return "display";
    }

    // ---------------- RAISE SALARY ----------------

    @GetMapping("/raise-form")
    public String raiseForm() {
        return "raiseSalary";
    }

    @PostMapping("/raiseSalary")
    public String raiseSalary(@RequestParam String name,
                              @RequestParam double percentage,
                              Model model) {

        if (percentage < 1 || percentage > 10) {

            model.addAttribute("message",
                    "Percentage should be between 1 and 10.");

            return "raiseSalary";
        }

        List<Employee> employees = repo.findByNameIgnoreCase(name);

        if (employees.isEmpty()) {

            model.addAttribute("message",
                    "Employee not found.");

            return "raiseSalary";
        }

        if (employees.size() > 1) {

            model.addAttribute("message",
                    "Multiple employees found with this name. All matching employees will be updated.");

        }

        for(Employee emp : employees){

            double newSalary =
                    emp.getSalary() +
                    (emp.getSalary()*percentage/100);

            emp.setSalary(newSalary);

            repo.save(emp);

        }

        model.addAttribute("updatedEmployees", employees);

        return "continueRaise";

    }

    // ---------------- EXIT ----------------

    @GetMapping("/exit")
    public String exit() {
        return "exit";
    }
}