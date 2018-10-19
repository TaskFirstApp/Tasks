package com.tasks.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public Object receiveMessage(String message) {
		System.out.println("Received : <" + message + ">");
		return "true" + " : Received";
	}
}
