package org.construction.userservice.controller;

import org.construction.userservice.dto.LoginRequestDto;
import org.construction.userservice.enums.Erole;
import org.construction.userservice.model.Person;
import org.construction.userservice.service.AuthenticationService;
import org.construction.userservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Person> register(@RequestBody Person person ) {
        Person registeredPerson = authenticationService.signup(person);
        return ResponseEntity.ok(registeredPerson);
    }



    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequestDto loginRequestDto) {

            Person authenticatedPerson = authenticationService.authenticate(loginRequestDto);
            Erole role = authenticatedPerson.getErole();

            String token = jwtService.generateToken(authenticatedPerson, role);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
    }

}
