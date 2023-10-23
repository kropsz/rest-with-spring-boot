package com.krops.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krops.rest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
