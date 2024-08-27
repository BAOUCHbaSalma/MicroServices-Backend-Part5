package org.construction.tacheservice.repository;

import org.construction.tacheservice.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache,Integer> {
}
