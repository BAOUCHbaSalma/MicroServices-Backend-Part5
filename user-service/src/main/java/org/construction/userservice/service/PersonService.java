package org.construction.userservice.service;

import org.construction.userservice.model.Person;
import org.construction.userservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    public Person findPersonByUsername(String username){

        return personRepository.findByUsername(username);

    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }

}
