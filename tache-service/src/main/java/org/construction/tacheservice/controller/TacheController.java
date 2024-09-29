package org.construction.tacheservice.controller;

import org.construction.tacheservice.classe.Projet;
import org.construction.tacheservice.dto.AssociateDto;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.projet.ProjetRest;
import org.construction.tacheservice.repository.TacheRepository;
import org.construction.tacheservice.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TacheController {


    @Autowired
    private TacheService tacheService;

    @GetMapping("/taches/{id}")
    public Page<Tache> showTaches(@PathVariable Integer id, @RequestParam Integer size,
                                  @RequestParam Integer page,
                                  @RequestParam(required = false) String sort){
        return tacheService.showTaches(id,size,page,sort);
    }

    @PostMapping("admin/taches/{id}")
    public Tache addTache(@PathVariable Integer id, @RequestBody Tache tache){
        return tacheService.addTache(id,tache);
    }

    @DeleteMapping("admin/taches/{id}")
    public void deleteTache(@PathVariable Integer id){
        tacheService.deleteTache(id);
    }

    @PutMapping("admin/taches/{id}")
    public Tache updateTache(@PathVariable Integer id,@RequestBody Tache tache){
        return tacheService.updateTache(id,tache);

    }

    @GetMapping("admin/taches/find/{id}")
    public Tache findById(@PathVariable Integer id){
        return tacheService.findById(id);
    }

    @DeleteMapping("admin/delete/p/{id}")
    void deleteByIdProjet(@PathVariable Integer id){
        tacheService.deleteByIdProjet(id);
    }




}
