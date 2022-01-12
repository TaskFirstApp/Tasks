package com.tasks.amqp;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureAMQP {
	/*
	 * static final String topicExchangeName = "q-user-exchange";
	 * 
	 * static final String queueName = "q-user";
	 * 
	 * @Bean Queue queue() { return new Queue(queueName, false); }
	 * 
	 * @Bean TopicExchange exchange() { return new TopicExchange(topicExchangeName);
	 * }
	 * 
	 * @Bean Binding binding(Queue queue, TopicExchange exchange) { return
	 * BindingBuilder.bind(queue).to(exchange).with("foo.bar.#"); }
	 * 
	 * @Bean SimpleMessageListenerContainer container(ConnectionFactory
	 * connectionFactory, MessageListenerAdapter listenerAdapter) {
	 * SimpleMessageListenerContainer container = new
	 * SimpleMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory);
	 * container.setQueueNames(queueName);
	 * container.setMessageListener(listenerAdapter); return container; }
	 * 
	 * @Bean MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
	 * return new MessageListenerAdapter(receiver, "receiveMessage"); }
	 */
	
}
