package org.construction.ressourceservice.repository;

import org.construction.ressourceservice.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RessourceRepository extends JpaRepository<Ressource,Integer> {

    List<Ressource> findAllByTacheId(Integer id);
}
