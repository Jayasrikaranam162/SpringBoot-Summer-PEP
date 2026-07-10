package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.Login;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUsernameException.class)
    public String handleUsernameException(InvalidUsernameException ex, Model model) {

        model.addAttribute("error", ex.getMessage());
        model.addAttribute("login", new Login());

        return "login";
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public String handlePasswordException(InvalidPasswordException ex, Model model) {

        model.addAttribute("error", ex.getMessage());
        model.addAttribute("login", new Login());

        return "login";
    }

}