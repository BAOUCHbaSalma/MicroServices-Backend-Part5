package com.user;

import org.construction.userservice.enums.Erole;
import org.construction.userservice.model.Admin;
import org.construction.userservice.model.Customer;
import org.construction.userservice.model.Person;
import org.construction.userservice.repository.PersonRepository;
import org.construction.userservice.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPerson_Customer() {
        // Arrange
        Person person = new Person();
        person.setUsername("salma");
        person.setEmail("salma@example.com");
        person.setPassword("salma123");
        person.setRole(Erole.CUSTOMER);

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(personRepository.save(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Person result = personService.addPerson(person);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof Customer);
        assertEquals("salma", result.getUsername());
        assertEquals("salma@example.com", result.getEmail());
        assertEquals("encodedPassword", result.getPassword());
        assertEquals(Erole.CUSTOMER, result.getRole());

        verify(passwordEncoder, times(1)).encode("salma123");
        verify(personRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testAddPerson_Admin() {
        // Arrange
        Person person = new Person();
        person.setUsername("mohamed");
        person.setEmail("mohamed@example.com");
        person.setPassword("mohamed123");
        person.setRole(Erole.ADMIN);

        when(passwordEncoder.encode(anyString())).thenReturn("encodedAdminPassword");
        when(personRepository.save(any(Admin.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Person result = personService.addPerson(person);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof Admin);
        assertEquals("mohamed", result.getUsername());
        assertEquals("mohamed@example.com", result.getEmail());
        assertEquals("encodedAdminPassword", result.getPassword());
        assertEquals(Erole.ADMIN, result.getRole());

        verify(passwordEncoder, times(1)).encode("mohamed123");
        verify(personRepository, times(1)).save(any(Admin.class));
    }


}