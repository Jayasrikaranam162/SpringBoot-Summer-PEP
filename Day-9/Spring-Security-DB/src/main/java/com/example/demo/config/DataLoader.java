package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadUsers(UserRepository repository,
                                PasswordEncoder passwordEncoder) {

        return args -> {

            if(repository.count()==0) {

                repository.save(
                        new AppUser(
                                "user",
                                passwordEncoder.encode("password"),
                                "USER"
                        )
                );

                repository.save(
                        new AppUser(
                                "admin",
                                passwordEncoder.encode("adminpass"),
                                "ADMIN"
                        )
                );

            }

        };
    }

}