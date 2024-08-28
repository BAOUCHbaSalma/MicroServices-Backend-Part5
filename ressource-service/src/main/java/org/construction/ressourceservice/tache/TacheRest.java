package org.construction.ressourceservice.tache;

import org.construction.ressourceservice.classe.Tache;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TACHE-SERVICE")
public interface TacheRest {

    @GetMapping("/taches/find/{id}")
    Tache findById(@PathVariable Integer id);
}
