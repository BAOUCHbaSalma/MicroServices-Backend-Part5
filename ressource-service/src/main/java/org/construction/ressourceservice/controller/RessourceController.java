package org.construction.ressourceservice.controller;

import org.construction.ressourceservice.dto.AssociateDto;
import org.construction.ressourceservice.model.Ressource;
import org.construction.ressourceservice.service.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;


    @GetMapping("ressources")
    public List<Ressource> showAll(){
        return ressourceService.showAll();
    }

    @GetMapping("ressources/{id}")
    public List<Ressource> findRessourceTache(@PathVariable Integer id){
        return ressourceService.findRessourceTache(id);
    }

    @PostMapping("admin/ressources")
    public Ressource addRessource(@RequestBody Ressource ressource){

        return ressourceService.addRessource(ressource);

    }

    @DeleteMapping("admin/ressources/{id}")
    public void deleteRessource(@PathVariable Integer id){
        ressourceService.deleteRessource(id);
    }

    @PutMapping("admin/ressources/{id}")
    public Ressource updateRessource(@PathVariable Integer id,@RequestBody Ressource ressource){
        return ressourceService.updateRessource(id,ressource);
    }

    @GetMapping("admin/find/{id}")
    public Ressource findById(@PathVariable Integer id){
        return ressourceService.findById(id);
    }

    @PutMapping("admin/associate/{idr}")
    public Ressource Associate(@PathVariable Integer idr, @RequestBody AssociateDto dto){
        return ressourceService.Associate(idr,dto.getIdTache());
    }



}
