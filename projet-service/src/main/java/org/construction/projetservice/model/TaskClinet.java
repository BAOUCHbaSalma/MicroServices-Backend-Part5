package org.construction.projetservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "TACHE-SERVICE" )
public interface TaskClinet {

    @DeleteMapping("admin/delete/p/{id}")
    void  deleteTache(@PathVariable Integer id);
}
