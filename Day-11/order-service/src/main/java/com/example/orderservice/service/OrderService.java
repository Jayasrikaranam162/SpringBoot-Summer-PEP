/*package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {

        return repository.save(order);

    }

}*/


package com.example.orderservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;
    public String placeOrder(String product){
        String paymentStatus=
                restTemplate.getForObject(
                        "http://localhost:8082/payment/"+product,
                        String.class);
        if(paymentStatus.equals("PAYMENT SUCCESS")){
            return "ORDER PLACED SUCCESSFULLY";
        }
        return "ORDER FAILED";
    }
}