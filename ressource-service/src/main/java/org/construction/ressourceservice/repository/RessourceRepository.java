package org.construction.ressourceservice.repository;

import org.construction.ressourceservice.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;




public interface RessourceRepository extends JpaRepository<Ressource,Integer> {
}
