package com.lgs.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgs.data.vo.v1.PersonVO;
import com.lgs.exceptions.ResourceNotFoundException;
import com.lgs.mapper.DozerMapper;
import com.lgs.model.Person;
import com.lgs.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<PersonVO> findAll() {
		logger.info("Finding All people!");
		return DozerMapper.parseListObjects( repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");

		Person person = new Person();
		person.setFirstName("Leo");
		person.setLastName("Siqueira");
		person.setAdress("Santos - São Paulo - Brasil");
		person.setGender("Male");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
	return DozerMapper.parseObject(entity, PersonVO.class);
	
	}

	public PersonVO update(PersonVO person) {
		logger.info("update one person!");
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
	var vo= DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		 return vo;
	}

	public PersonVO create(PersonVO obj) {
		logger.info("Create one person!");
		var entity = DozerMapper.parseObject(obj, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		repository.delete(entity);
	}

}
