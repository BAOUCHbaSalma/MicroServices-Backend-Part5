package org.construction.projetservice.controller;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.construction.projetservice.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjetController {

    @Autowired
    private ProjetService projetService;


//   @GetMapping("/projets")
//    public List<Projet> findAll(){
//       return projetService.showProjet();
//    }
    @GetMapping("/projets")
    public Page<Projet> findAll(@RequestParam Integer size,@RequestParam Integer page, @RequestParam(required = false) String sort){
        return projetService.showProjet(page,size,sort );
    }

    @PostMapping("admin/projets")
    public Projet addProjet(@RequestBody Projet projet){
        return projetService.addProjet(projet);
    }

    @DeleteMapping("admin/projets/{id}")
    public void deleteProjet(@PathVariable Integer id){
        projetService.deleteProjet(id);
    }

    @PutMapping("admin/projets/{id}")
    public Projet updateProjet(@PathVariable Integer id,@RequestBody Projet projet){
        return projetService.updateProjet(id,projet);
    }
    @GetMapping("admin/projets/{id}")
    public Projet findById(@PathVariable Integer id){
        return projetService.findById(id);
    }
}
