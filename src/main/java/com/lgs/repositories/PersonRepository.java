package com.lgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lgs.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
