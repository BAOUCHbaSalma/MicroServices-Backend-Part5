package org.construction.tacheservice.controller;

import org.construction.tacheservice.classe.Projet;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.projet.ProjetRest;
import org.construction.tacheservice.repository.TacheRepository;
import org.construction.tacheservice.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TacheController {


    @Autowired
    private TacheService tacheService;

    @GetMapping("/taches/{id}")
    public List<Tache> showTaches(@PathVariable Integer id){
        return tacheService.showTaches(id);
    }

    @PostMapping("/taches/{id}")
    public Tache addTache(@PathVariable Integer id, @RequestBody Tache tache){
        return tacheService.addTache(id,tache);
    }

    @DeleteMapping("taches/{id}")
    public void deleteTache(@PathVariable Integer id){
        tacheService.deleteTache(id);
    }

    

}
