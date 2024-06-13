package com.lgs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.lgs.model.Person;

@Service
public class PersonServices {

	private static final AtomicLong counter = new AtomicLong();

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("Finding All people!");

		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leo");
		person.setLastName("Siqueira");
		person.setAdress("Santos - São Paulo - Brasil");
		person.setGender("Male");
		return person;
	}

	public Person updatePerson(Person obj) {
		logger.info("update one person!");
		return obj;
	}

	public Person createPerson(Person obj) {
		logger.info("Create one person!");
		return obj;
	}

	public void delete(String id) {
		logger.info("deleting one person!");
	}

	private Person mockPerson(int i) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAdress("Some adress in Brasil" + i);
		person.setGender("Male");
		return person;
	}
}
