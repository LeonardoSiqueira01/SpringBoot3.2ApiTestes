package com.lgs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgs.data.vo.v1.PersonVO;
import com.lgs.data.vo.v2.PersonVOV2;
import com.lgs.services.PersonServices;
import com.lgs.util.MediaType;

@RequestMapping("/person/v1")
@RestController
public class PersonController {

	@Autowired
	public PersonServices services;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			 MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return services.findById(id);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<PersonVO> findAll() {
		return services.findAll();
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML}, produces = {
			MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML}, produces = {
			MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}

	@PostMapping(value = "v2/", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML}, produces = {
			MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return services.createV2(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
