package com.lgs.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.lgs.data.vo.v2.PersonVOV2;
import com.lgs.model.Person;

@Service
public class PersonMapper {
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAdress(person.getAdress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		return vo;
	}
	public Person convertVoToEntity(PersonVOV2 vo) {
		Person person = new Person();
		person.setId(vo.getId());
		person.setAdress(vo.getAdress());
		person.setFirstName(vo.getFirstName());
		person.setLastName(vo.getLastName());
		person.setGender(vo.getGender());
		return person;
	}
}
