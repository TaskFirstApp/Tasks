package com.tasks.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public boolean send() {
		
		return false;
	}
}
