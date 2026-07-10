package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeDashboardController {

    @GetMapping("/employee/dashboard")
    public String employeeDashboard() {
        return "employee-dashboard";
    }
}