package org.construction.projetservice.controller;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;


    @GetMapping("/projects")
    public List<Projet> findAll(){
        return projetRepository.findAll();
    }
}
