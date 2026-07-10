package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "orderss", groupId = "myGroup")
	public void consume(@Header(KafkaHeaders.RECEIVED_KEY) String id, @Payload String message) {
		System.out.println("Consumer Received : id=" + id + ", message=" + message);
	}

}
