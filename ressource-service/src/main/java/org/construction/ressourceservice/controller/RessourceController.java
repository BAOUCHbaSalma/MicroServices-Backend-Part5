package org.construction.ressourceservice.controller;

import jakarta.ws.rs.Path;
import org.construction.ressourceservice.dto.AssociateRessourceDTO;
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

    @GetMapping("/ressources/{id}")
    public List<Ressource> findRessourceTache(@PathVariable Integer id){
        return ressourceService.findRessourceTache(id);
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

    @PutMapping("/ressources/associate/{idr}")
    public Ressource associate(@PathVariable Integer idr, @RequestBody AssociateRessourceDTO dto) {
        return ressourceService.associate(dto.getIdTache(), idr);
    }

}
