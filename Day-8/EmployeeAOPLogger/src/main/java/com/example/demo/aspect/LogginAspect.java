package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    @Before("execution(* com.example.demo.service.MyService.displayMessage(..))")
    public void beforeAdvice() {
        System.out.println("Before Interview Process");
    }

    @After("execution(* com.example.demo.service.MyService.displayMessage(..))")
    public void afterAdvice() {
        System.out.println("After Interview Process");
    }
}