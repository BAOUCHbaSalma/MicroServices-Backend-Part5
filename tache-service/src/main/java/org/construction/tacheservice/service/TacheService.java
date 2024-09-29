package org.construction.tacheservice.service;

import org.construction.tacheservice.classe.Projet;
import org.construction.tacheservice.dto.AssociateDto;
import org.construction.tacheservice.model.EStatus;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.projet.ProjetRest;
import org.construction.tacheservice.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private ProjetRest projetRest;

    public Tache addTache(Integer id,Tache tache){
        tache.setProjetId(id);
        tache.setDateCreation(LocalDate.now());
        tache.setStatus(EStatus.A_FAIRE);
        return tacheRepository.save(tache);
    }

    public Tache findById(Integer id){

        return tacheRepository.findById(id).orElseThrow();
    }

    public Page<Tache> showTaches(Integer id, Integer size, Integer page, String sort, String description) {
        // Determine the sort order
        Sort sortOrder = Sort.unsorted();
        if (sort != null && !sort.isEmpty()) {
            String[] sortParams = sort.split(",");
            sortOrder = Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]);
        }

        // Create a Pageable object with the provided parameters
        Pageable pageable = PageRequest.of(page, size, sortOrder);

        // Check for description filter and return accordingly
        if (description != null && !description.isEmpty()) {
            return tacheRepository.findAllByProjetIdAndDescriptionContainingIgnoreCase(id, description, pageable);
        }

        // If no description filter, return all tasks for the project with pagination
        return tacheRepository.findAllByProjetId(id, pageable);
    }


    public void deleteTache(Integer id){
        tacheRepository.deleteById(id);
    }

    public Tache updateTache(Integer id,Tache tache){
        Tache tache1=tacheRepository.findById(id).orElseThrow();
        tache1.setDateFin(tache.getDateFin());
        tache1.setStatus(tache.getStatus());
        tache1.setDescription(tache.getDescription());
        return tacheRepository.save(tache1);

    }
   public void deleteByIdProjet(Integer id){
        tacheRepository.deleteAllByProjetId(id);
    }

//    public List<Tache> showTachesWithFilter(Integer projetId, String description) {
//        if (description != null && !description.isEmpty()) {
//            return tacheRepository.findAllByProjetIdAndDescriptionContainingIgnoreCase(projetId, description);
//        }
//        return tacheRepository.findAllByProjetId(projetId);
//    }


}
