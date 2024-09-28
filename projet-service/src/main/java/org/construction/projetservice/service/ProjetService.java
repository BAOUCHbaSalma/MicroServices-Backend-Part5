package org.construction.projetservice.service;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.model.TaskClinet;
import org.construction.projetservice.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private TaskClinet taskClinet;


    public Projet addProjet(Projet projet){
        projet.setDateCreation(LocalDate.now());
        return projetRepository.save(projet);

    }
//    public List<Projet> showProjet(){
//        return projetRepository.findAll();
//    }

    public Page<Projet> showProjet(Integer page, Integer size, String sort, String name, Double minBudget, Double maxBudget, String startDate, String endDate) {
        Sort sortOrder = Sort.unsorted();
        if (sort != null && !sort.isEmpty()) {
            String[] sortParams = sort.split(",");
            sortOrder = Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]);
        }

        // Utiliser une specification pour le filtrage
        Specification<Projet> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        }
        if (minBudget != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("budget"), minBudget));
        }
        if (maxBudget != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("budget"), maxBudget));
        }
        if (startDate != null && !startDate.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dateCreation"), LocalDate.parse(startDate)));
        }
        if (endDate != null && !endDate.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("dateCreation"), LocalDate.parse(endDate)));
        }

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return projetRepository.findAll(spec, pageable);
    }


    public Projet findById(Integer id){
        return projetRepository.findById(id).orElseThrow();
    }


    public void deleteProjet(Integer id){

        projetRepository.deleteById(id);
        taskClinet.deleteTache(id);
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
