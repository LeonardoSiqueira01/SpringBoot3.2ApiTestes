package com.lgs.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgs.exceptions.ResourceNotFoundException;
import com.lgs.model.Person;
import com.lgs.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("Finding All people!");
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Finding one person!");

		Person person = new Person();
		person.setFirstName("Leo");
		person.setLastName("Siqueira");
		person.setAdress("Santos - São Paulo - Brasil");
		person.setGender("Male");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
	}

	public Person update(Person person) {
		logger.info("update one person!");
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}

	public Person create(Person obj) {
		logger.info("Create one person!");
		return repository.save(obj);
	}

	public void delete(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		repository.delete(entity);
	}

}
