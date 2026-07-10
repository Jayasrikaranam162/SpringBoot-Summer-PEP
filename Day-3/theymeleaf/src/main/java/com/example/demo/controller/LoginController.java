package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    // 1. Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";   // login.html
    }
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        // Hardcoded validation (for learning)
        if (username.equals("admin") && password.equals("1234")) {
            model.addAttribute("username", username);
            return "welcome";   // welcome.html
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }
    }
}