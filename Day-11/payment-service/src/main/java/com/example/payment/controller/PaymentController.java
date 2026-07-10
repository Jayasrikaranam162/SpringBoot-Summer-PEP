package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment savePayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return service.getPaymentById(id);
    }
}