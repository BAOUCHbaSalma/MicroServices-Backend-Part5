package org.construction.ressourceservice.service;

import org.construction.ressourceservice.classe.Tache;
import org.construction.ressourceservice.model.Ressource;
import org.construction.ressourceservice.repository.RessourceRepository;

import org.construction.ressourceservice.tache.TacheRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private TacheRest tacheRest;




    public Ressource addRessource(Ressource ressource){
        return ressourceRepository.save(ressource);
    }

    public List<Ressource> showAll(){

        List<Ressource> ressourceList= ressourceRepository.findAll();

        for (Ressource ressource:ressourceList){
            if (ressource.getTacheId()!=null){
            Tache tache=tacheRest.findById(ressource.getTacheId());
            ressource.setTache(tache);
            }
        }
        return ressourceList;
    }

    public List<Ressource> findRessourceTache(Integer id){
        List<Ressource> ressourceList= ressourceRepository.findAllByTacheId(id);
        Tache tache=tacheRest.findById(id);

        for (Ressource ressource:ressourceList){
            ressource.setTache(tache);

        }
        return ressourceList;
    }

    public Ressource findById(Integer id){
        return ressourceRepository.findById(id).orElseThrow();
    }

    public Ressource updateRessource(Integer id,Ressource ressource){
        Ressource ressource1=findById(id);
        ressource1.setName(ressource.getName());
        ressource1.setQuantity(ressource.getQuantity());
        ressource1.setInfoFornisseur(ressource.getInfoFornisseur());
        ressource1.setPicture(ressource.getPicture());
        return  ressourceRepository.save(ressource1);

    }

    public Ressource associate(Integer idTache,Integer idRessource){
        Ressource ressource=findById(idRessource);
        ressource.setTacheId(idTache);
        return ressourceRepository.save(ressource);
    }

    public void deleteRessource(Integer id){
        ressourceRepository.deleteById(id);
    }
}
