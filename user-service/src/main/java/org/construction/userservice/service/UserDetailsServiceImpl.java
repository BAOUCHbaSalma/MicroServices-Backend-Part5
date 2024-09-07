package org.construction.userservice.service;

import org.construction.userservice.model.Person;
import org.construction.userservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        System.out.println(person.getUsername()+"///:::22IMPL/"+ person.getPassword());
        return person.builder().username(person.getUsername()).password(person.getPassword()).role(person.getRole()).build();
    }
}