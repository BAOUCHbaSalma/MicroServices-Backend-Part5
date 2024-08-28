package org.construction.projetservice.repository;

import org.construction.projetservice.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjetRepository extends JpaRepository<Projet,Integer> {
}
