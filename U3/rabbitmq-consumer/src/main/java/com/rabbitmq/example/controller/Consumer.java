package com.rabbitmq.example.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.example.dto.PaymentStatus;

@Component
public class Consumer {

	public static final String QUEUE_2 = "queue-2";

	@RabbitListener(queues = QUEUE_2)
	public void consumeMessageFromQueue(PaymentStatus paymentStatus) {
		System.out.println("Message received from queue: \n\n" + paymentStatus.toString());
	}
}
