package org.construction.tacheservice.repository;

import org.construction.tacheservice.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TacheRepository extends JpaRepository<Tache,Integer> {
}
