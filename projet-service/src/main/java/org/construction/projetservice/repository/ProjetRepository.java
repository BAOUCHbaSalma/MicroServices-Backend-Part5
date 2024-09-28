package org.construction.projetservice.repository;

import org.construction.projetservice.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjetRepository extends JpaRepository<Projet, Integer>, JpaSpecificationExecutor<Projet> {
}
