package org.construction.tacheservice.repository;

import org.construction.tacheservice.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TacheRepository extends JpaRepository<Tache,Integer> {
    List<Tache> findAllByProjetId(Integer id);
    void deleteAllByProjetId(Integer idP);
}
