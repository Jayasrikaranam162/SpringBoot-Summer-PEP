package com.example.demo.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentRestConsumer {

    private RestTemplate rt = new RestTemplate();

    public String getPaymentData() {
    	return rt.getForObject(
    		    "http://localhost:8989/payment/data",
    		    String.class
    		);
    }
}