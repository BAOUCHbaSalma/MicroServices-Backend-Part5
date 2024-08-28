package org.construction.tacheservice.projet;

import org.construction.tacheservice.classe.Projet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJET-SERVICE")
public interface ProjetRest {

    @GetMapping("/projets/{id}")
    Projet findById(@PathVariable Integer id);
}

