package org.construction.projetservice.controller;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.construction.projetservice.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjetController {

    @Autowired
    private ProjetService projetService;


    @GetMapping("/projects")
    public List<Projet> findAll(){
        return projetService.showProjet();
    }

    @PostMapping("/projets")
    public Projet addProjet(@RequestBody Projet projet){
        return projetService.addProjet(projet);
    }
    
}
