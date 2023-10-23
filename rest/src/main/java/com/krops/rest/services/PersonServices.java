package com.krops.rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krops.rest.data.vo.v1.PersonVO;
import com.krops.rest.exceptions.ResourcesNotFound;
import com.krops.rest.model.Person;
import com.krops.rest.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Find all people");


        return repository.findAll();
    }

    public PersonVO findById(Long id) {
        logger.info("Find one PersonVO");
        return repository.findById(id).orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
    }

    public PersonVO create(PersonVO PersonVO) {
        logger.info("Create PersonVO");
        return repository.save(PersonVO);
    }

    public PersonVO update(PersonVO PersonVO) {
        logger.info("Update PersonVO");

        var entity = repository.findById(PersonVO.getId())
                .orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
        entity.setFirstName(PersonVO.getFirstName());
        entity.setLastName(PersonVO.getLastName());
        entity.setGender(PersonVO.getGender());
        entity.setAddress(PersonVO.getAddress());
        return repository.save(PersonVO);
    }

    public void delte(Long id) {
        logger.info("delete PersonVO");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFound("No record found for this id"));
        repository.delete(entity);

    }

}
