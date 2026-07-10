package com.example.demo.config;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(
            RoleRepository roleRepository,
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN")
                    .orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));

            Role employeeRole = roleRepository.findByRoleName("ROLE_EMPLOYEE")
                    .orElseGet(() -> roleRepository.save(new Role("ROLE_EMPLOYEE")));

            if (appUserRepository.findByUsername("admin").isEmpty()) {

                AppUser admin = new AppUser();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setEnabled(true);
                admin.setCreatedAt(LocalDateTime.now());
                admin.setRoles(Set.of(adminRole));

                appUserRepository.save(admin);
            }

            if (appUserRepository.findByUsername("employee").isEmpty()) {

                AppUser employee = new AppUser();
                employee.setUsername("employee");
                employee.setPassword(passwordEncoder.encode("employee123"));
                employee.setEnabled(true);
                employee.setCreatedAt(LocalDateTime.now());
                employee.setRoles(Set.of(employeeRole));

                appUserRepository.save(employee);
            }
        };
    }
}