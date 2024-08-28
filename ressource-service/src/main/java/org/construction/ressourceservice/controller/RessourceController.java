package org.construction.ressourceservice.controller;

import jakarta.ws.rs.Path;
import org.construction.ressourceservice.model.Ressource;
import org.construction.ressourceservice.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;


    @GetMapping("/ressources")
    public List<Ressource> showAll(){
        return ressourceService.showAll();
    }

    @PostMapping("/ressources")
    public Ressource addRessource(@RequestBody Ressource ressource){

        return ressourceService.addRessource(ressource);

    }

    @DeleteMapping("/ressources/{id}")
    public void deleteRessource(@PathVariable Integer id){
        ressourceService.deleteRessource(id);
    }

    @PutMapping("/ressources/{id}")
    public Ressource updateRessource(@PathVariable Integer id,@RequestBody Ressource ressource){
        return ressourceService.updateRessource(id,ressource);
    }
}
