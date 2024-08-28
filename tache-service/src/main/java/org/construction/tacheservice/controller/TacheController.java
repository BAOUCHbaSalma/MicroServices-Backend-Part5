package org.construction.tacheservice.controller;

import org.construction.tacheservice.classe.Projet;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.projet.ProjetRest;
import org.construction.tacheservice.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TacheController {

    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private ProjetRest projetRest;

    @GetMapping("/taches/{id}")
    public Tache findById(@PathVariable Integer id){
        Tache tache=tacheRepository.findById(id).orElseThrow();
        Projet projet=projetRest.findById(tache.getProjetId());
        tache.setProjet(projet);
        return tache;

    }
}
