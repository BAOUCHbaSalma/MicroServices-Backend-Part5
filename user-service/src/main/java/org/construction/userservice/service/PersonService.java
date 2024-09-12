package org.construction.userservice.service;

import org.construction.userservice.enums.Erole;
import org.construction.userservice.model.Admin;
import org.construction.userservice.model.Customer;
import org.construction.userservice.model.Person;
import org.construction.userservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;
    @Autowired

    private PasswordEncoder passwordEncoder;
    public Person findPersonByUsername(String username){

        return personRepository.findByUsername(username);

    }
    public Person addPerson(Person person){
        if (person.getRole() == Erole.CUSTOMER) {
            Customer customer = new Customer();

            customer.setUsername(person.getUsername());
            customer.setEmail(person.getEmail());
            customer.setPassword(passwordEncoder.encode(person.getPassword()));
            customer.setRole(person.getRole());
            return personRepository.save(customer);

        } else if (person.getRole() == Erole.ADMIN) {
            Admin admin = new Admin();
            admin.setUsername(person.getUsername());
            admin.setEmail(person.getEmail());
            admin.setPassword(passwordEncoder.encode(person.getPassword()));
            admin.setRole(person.getRole());
            return personRepository.save(admin);
        }
        return person;
    }
    public Integer findIdByUsername(String username){
        return personRepository.findIdByUsername(username);
    }

}
