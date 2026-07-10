package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String loginPage(Model model) {

        model.addAttribute("login", new Login());
        return "login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute Login login) {

        loginService.validate(login);

        return "welcome";

    }

}