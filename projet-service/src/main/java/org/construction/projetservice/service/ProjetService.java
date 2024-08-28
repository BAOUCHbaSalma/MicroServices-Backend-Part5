package org.construction.projetservice.service;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;


    public Projet addProjet(Projet projet){
        projet.setDateCreation(LocalDate.now());
        return projetRepository.save(projet);

    }
    public List<Projet> showProjet(){
        return projetRepository.findAll();
    }

    public Projet findById(Integer id){
        return projetRepository.findById(id).orElseThrow();
    }


    public void deleteProjet(Integer id){
        projetRepository.deleteById(id);
    }

    public Projet updateProjet(Integer id,Projet projet){
        Projet projet1=projetRepository.findById(id).orElseThrow();
        projet1.setName(projet.getName());
        projet1.setBudget(projet.getBudget());
        projet1.setDateFin(projet.getDateFin());
        projet1.setDescription(projet.getDescription());

        return projetRepository.save(projet1);

    }

}
