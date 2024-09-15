package org.construction.ressourceservice.service;

import org.construction.ressourceservice.classe.Tache;
import org.construction.ressourceservice.dto.AssociateDto;
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
        return ressourceRepository.findAll();
    }

    public List<Ressource> findRessourceTache(Integer id){
        return ressourceRepository.findAllByTacheId(id);
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

//    public void assignTache(Integer idRessource, Integer idTache) {
//        Ressource ressource = ressourceRepository.findById(idRessource).orElseThrow();
//        ressource.setTacheId(idTache);
//         ressourceRepository.save(ressource);
//    }

    public void deleteRessource(Integer id){
        ressourceRepository.deleteById(id);
    }

    public Ressource Associate(Integer idr, Integer idT){
        Ressource ressource=findById(idr);
        ressource.setTacheId(idT);
        return ressourceRepository.save(ressource);
    }
}
