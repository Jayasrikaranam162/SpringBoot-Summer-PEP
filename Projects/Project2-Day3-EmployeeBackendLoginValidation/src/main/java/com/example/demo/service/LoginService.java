package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidPasswordException;
import com.example.demo.exception.InvalidUsernameException;
import com.example.demo.model.Login;

@Service
public class LoginService {

    public void validate(Login login) {

        String username = login.getUsername();
        String password = login.getPassword();

        // Username Validation

        if (username == null || username.trim().isEmpty()) {
            throw new InvalidUsernameException("Username cannot be empty.");
        }

        if (username.length() < 5) {
            throw new InvalidUsernameException("Username must contain at least 5 characters.");
        }

        if (username.length() > 20) {
            throw new InvalidUsernameException("Username cannot exceed 20 characters.");
        }

        if (username.contains(" ")) {
            throw new InvalidUsernameException("Username should not contain spaces.");
        }


        // Password Validation

        if (password == null || password.trim().isEmpty()) {
            throw new InvalidPasswordException("Password cannot be empty.");
        }

        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must contain at least 8 characters.");
        }

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch))
                upper = true;

            else if (Character.isLowerCase(ch))
                lower = true;

            else if (Character.isDigit(ch))
                digit = true;

            else
                special = true;
        }

        if (!upper) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }

        if (!lower) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }

        if (!digit) {
            throw new InvalidPasswordException("Password must contain at least one number.");
        }

        if (!special) {
            throw new InvalidPasswordException("Password must contain at least one special character.");
        }

    }

}