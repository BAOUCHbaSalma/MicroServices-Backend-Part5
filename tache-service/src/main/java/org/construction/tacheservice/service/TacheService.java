package org.construction.tacheservice.service;

import org.construction.tacheservice.classe.Projet;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.projet.ProjetRest;
import org.construction.tacheservice.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private ProjetRest projetRest;

    public Tache addTache(Integer id,Tache tache){
        tache.setProjetId(id);
        Projet projet=projetRest.findById(id);
        tache.setProjet(projet);
        return tacheRepository.save(tache);
    }

    public Tache findById(Integer id){
        return tacheRepository.findById(id).orElseThrow();
    }

    public List<Tache> showTaches(Integer id){

        return tacheRepository.findAllByProjetId(id);

    }

    public void deleteTache(Integer id){
        tacheRepository.deleteById(id);
    }

    public Tache updateTache(Integer id,Tache tache){
        Tache tache1=tacheRepository.findById(id).orElseThrow();
        tache1.setDateFin(tache.getDateFin());
        tache1.setStatus(tache.getStatus());
        tache1.setDescription(tache.getDescription());
        return tacheRepository.save(tache);

    }


}
