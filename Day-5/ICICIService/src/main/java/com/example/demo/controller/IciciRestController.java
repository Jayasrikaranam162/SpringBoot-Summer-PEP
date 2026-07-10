package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.CartRestConsumer;
import com.example.demo.consumer.PaymentRestConsumer;

@RestController
public class IciciRestController {

    @Autowired
    private CartRestConsumer cartConsumer;

    @Autowired
    private PaymentRestConsumer paymentConsumer;

    @GetMapping("/icici/data")
    public String getIciciData() {

        String cart = cartConsumer.getCartData();
        String payment = paymentConsumer.getPaymentData();

        return "ICICI SERVICE<br>"
                + "<br>" + cart
                + "<br>" + payment;
    }
}