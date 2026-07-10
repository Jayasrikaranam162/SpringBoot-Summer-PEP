package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent()) {

            if(user.get().getPassword().equals(password)) {

                model.addAttribute("username", username);
                return "welcome";
            }
        }

        model.addAttribute("error","Invalid Username or Password");
        return "login";
    }

}