package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "Welcome To Public Page";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "Welcome To User Page";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "Welcome To Admin Page";
	}

}