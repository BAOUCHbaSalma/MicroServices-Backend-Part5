package org.construction.ressourceservice.repository;

import org.construction.ressourceservice.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface RessourceRepository extends JpaRepository<Ressource,Integer> {
}
