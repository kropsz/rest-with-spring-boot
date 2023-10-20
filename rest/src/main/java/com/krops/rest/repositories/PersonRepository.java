package com.krops.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krops.rest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
