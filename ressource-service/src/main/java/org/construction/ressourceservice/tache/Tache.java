package org.construction.ressourceservice.tache;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TACHE-SERVICE")
public interface Tache {

    @GetMapping("/taches/find/{id}")
    Tache findById(@PathVariable Integer id);
}
