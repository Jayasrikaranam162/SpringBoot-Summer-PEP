package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductAsyncService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Async
	public void fetchProduct()
	{
		System.out.println("");
		String response=  restTemplate.getForObject("http://localhost:8081/product", String.class);
		System.out.println("Product Received. " + response);
	}
	
	// NEW METHOD
	public String fetchProductSync()
	{
	    String response = restTemplate.getForObject(
	            "http://localhost:8081/product",
	            String.class);

	    return response;
	}
}
