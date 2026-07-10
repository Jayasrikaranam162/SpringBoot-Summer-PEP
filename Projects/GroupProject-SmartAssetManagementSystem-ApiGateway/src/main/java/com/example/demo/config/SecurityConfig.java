package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/vendor/**",
                    "/login",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                .requestMatchers("/employee/dashboard").hasRole("EMPLOYEE")

                .requestMatchers(
                    "/dashboard",
                    "/ui/departments/**",
                    "/ui/employees/**",
                    "/ui/categories/**",
                    "/ui/vendors/**",
                    "/ui/assets/**",
                    "/ui/assignments/**",
                    "/ui/maintenance/**",
                    "/ui/damage-reports/**"
                ).hasRole("ADMIN")

                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")
                .successHandler((request, response, authentication) -> {

                    boolean isAdmin = authentication.getAuthorities()
                            .stream()
                            .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

                    boolean isEmployee = authentication.getAuthorities()
                            .stream()
                            .anyMatch(auth -> auth.getAuthority().equals("ROLE_EMPLOYEE"));

                    if (isAdmin) {
                        response.sendRedirect("/dashboard");
                    } else if (isEmployee) {
                        response.sendRedirect("/employee/dashboard");
                    } else {
                        response.sendRedirect("/access-denied");
                    }
                })
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )

            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}