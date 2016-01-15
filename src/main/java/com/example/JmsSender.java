package com.example;

import javax.annotation.PostConstruct;

import com.example.domain.Person;
import com.example.domain.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

@Component
class JmsSender {

	private static final Logger logger = LoggerFactory.getLogger(JmsSender.class);

	private final JmsTemplate jmsTemplate;

	private final MappingJackson2MessageConverter jmsConverter;

	@Autowired
	public JmsSender(JmsTemplate jmsTemplate, MappingJackson2MessageConverter jmsConverter) {
		this.jmsTemplate = jmsTemplate;
		this.jmsConverter = jmsConverter;
	}

	@PostConstruct
	public void init() {
		Person p = new Person();
		p.setFirstName("John");
		p.setLastName("Smith");
		p.setAddress("5th Avenue - NY");
		p.setBio("Bla bla bla bla bla bla");
		logger.info("Sending message with " + p);
		send(p);
	}

	public void send(Person person) {
		this.jmsTemplate.send("persons", s -> {
			return this.jmsConverter.toMessage(person, s, Views.Normal.class);
		});
	}

}
