package com.krops.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.krops.rest.model.Person;


@Service    
public class PersonServices {

    private static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


 public List<Person> findAll(){
    List<Person> persons = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
    }
    return persons;
}

    private Person mockPerson(int i) {
    Person person = new Person();
        logger.info("Finda all person");
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name" + i );
        person.setLastName("Last Name" + i);
        person.setGender("Male");
        person.setAddress("Some Address in Brazil" + i);
        return person;
}

    public Person findById(String id){
        logger.info("Find one person"); 
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName(("Esteves"));
        person.setGender("Masc");
        person.setAddress("Joao Monlevade, Alvorada, Brasil");
        return person;
    }

    public Person create(Person person){
        logger.info("Create person");
        

        return person;
    }

    public Person update(Person person){
        logger.info("Update person");
        
        
        return person;
    }

    public void delte(String id){

        logger.info("delete person");
        
    }

}
