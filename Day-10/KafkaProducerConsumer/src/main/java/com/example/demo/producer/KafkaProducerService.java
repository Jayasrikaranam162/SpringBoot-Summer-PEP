package com.example.demo.producer;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String, String> kafkaTemplate;
	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public String sendMessage(String message) {
		String id = UUID.randomUUID().toString();
		kafkaTemplate.send("orderss", id, message);
		System.out.println("Producer Sent : id=" + id + ", message=" + message);
		return id;
	}

}
