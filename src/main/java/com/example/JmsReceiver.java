package com.example;

import com.example.domain.Person;
import com.example.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
class JmsReceiver {

	private static final Logger logger = LoggerFactory.getLogger(JmsReceiver.class);

	@JmsListener(destination = "persons")
	@SendTo("personsAgain")
	@JsonView(Views.Summary.class)
	public Person handlePerson(Person person) {
		logger.info("Handling " + person);
		return person;
	}

	@JmsListener(destination = "personsAgain")
	public void handlePersonAgain(Person person) {
		logger.info("Handling _again_ " + person);
	}

}
