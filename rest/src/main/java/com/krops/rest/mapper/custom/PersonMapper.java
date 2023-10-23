package com.krops.rest.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.krops.rest.data.vo.v2.PersonVOV2;
import com.krops.rest.model.Person;

@Service
public class PersonMapper {
    
    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDate(new Date());
    
        return vo;
    }   


     public Person convertVoToEntity(PersonVOV2 person){
        Person pers = new Person();
        pers.setId(person.getId());
        pers.setFirstName(person.getFirstName());
        pers.setLastName(person.getLastName());
        pers.setAddress(person.getAddress());
        pers.setGender(person.getGender());
        //pers.setBirthDate(new Date());
    
        return pers;
    }   
}
