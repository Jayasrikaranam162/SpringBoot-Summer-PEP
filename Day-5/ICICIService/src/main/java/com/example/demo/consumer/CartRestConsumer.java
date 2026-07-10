package com.example.demo.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartRestConsumer {

    private RestTemplate rt = new RestTemplate();

    public String getCartData() {
        return rt.getForObject(
                "http://localhost:9009/cart/getData",
                String.class);
    }
}