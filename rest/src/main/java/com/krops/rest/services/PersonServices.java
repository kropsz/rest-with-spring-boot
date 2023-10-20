package com.krops.rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krops.rest.exceptions.ResourcesNotFound;
import com.krops.rest.model.Person;
import com.krops.rest.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Find all people");


        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find one person");
        return repository.findById(id).orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
    }

    public Person create(Person person) {
        logger.info("Create person");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update person");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        return repository.save(person);
    }

    public void delte(Long id) {
        logger.info("delete person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
        repository.delete(entity);

    }

}
