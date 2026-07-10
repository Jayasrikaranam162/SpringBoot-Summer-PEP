/*package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {

        return service.saveOrder(order);

    }

}*/

package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.orderservice.service.OrderService;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;
    @GetMapping("/{product}")
    public String placeOrder(@PathVariable String product){

        return service.placeOrder(product);

    }

}