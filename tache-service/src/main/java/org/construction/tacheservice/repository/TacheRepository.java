package org.construction.tacheservice.repository;

import org.construction.tacheservice.model.Tache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TacheRepository extends JpaRepository<Tache,Integer> {
    Page<Tache> findAllByProjetId(Integer id, Pageable pageable);
    void deleteAllByProjetId(Integer idP);
}
