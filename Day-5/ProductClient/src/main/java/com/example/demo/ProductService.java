package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public void syncMethod() {

        String result = restTemplate.getForObject(
                "http://localhost:8081/sync",
                String.class);

        System.out.println(result);
    }

    @Async
    public void asyncMethod() {

        String result = restTemplate.getForObject(
                "http://localhost:8081/async",
                String.class);

        System.out.println(result);
    }
}