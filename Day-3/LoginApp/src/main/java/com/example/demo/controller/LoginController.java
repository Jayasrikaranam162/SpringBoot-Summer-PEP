package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.validation.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginValidator loginValidator;

    // Show login page
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // Step 1: Validate username
        String usernameError = loginValidator.validateUsername(username);
        if (usernameError != null) {
            model.addAttribute("error", usernameError);
            return "login";
        }

        // Step 2: Validate password
        String passwordError = loginValidator.validatePassword(password);
        if (passwordError != null) {
            model.addAttribute("error", passwordError);
            return "login";
        }

        // Step 3: Authenticate against DB
        boolean isAuthenticated = userService.authenticate(username, password);

        if (isAuthenticated) {
            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}