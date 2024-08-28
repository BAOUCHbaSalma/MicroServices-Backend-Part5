package org.construction.projetservice.controller;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.construction.projetservice.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/projets/{id}")
    public void deleteProjet(@PathVariable Integer id){
        projetService.deleteProjet(id);
    }

    @PutMapping("/projets/{id}")
    public Projet updateProjet(@PathVariable Integer id,@RequestBody Projet projet){
        return projetService.updateProjet(id,projet);
    }
}
