package org.construction.projetservice;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.service.ProjetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjetServiceApplicationTests {

    @Autowired
    private ProjetService projetService;




    @Test
    void showProjetTest() {
        List<Projet> projets = projetService.showProjet();
        assertEquals(1, projets.get(0).getId());
        assertEquals(20, projets.get(1).getId());
        assertEquals(29, projets.get(2).getId());

    }

    @Test
    void findByIdTest(){

        Projet projet=projetService.findById(1);
        assertEquals(1,projet.getId());

    }

    @Test
    void addProjetTest() {
        Projet projet = new Projet();
        projet.setName("Nouveau Projet");
        projet.setBudget(100000);
        projet.setDescription("Description du projet");
        projet.setDateFin(LocalDate.of(2024, 12, 31));

        Projet savedProjet = projetService.addProjet(projet);

        assertEquals("Nouveau Projet", savedProjet.getName());
        assertEquals(100000, savedProjet.getBudget());
        assertEquals(LocalDate.now(), savedProjet.getDateCreation());
        assertEquals(LocalDate.of(2024, 12, 31), savedProjet.getDateFin());
    }


}
