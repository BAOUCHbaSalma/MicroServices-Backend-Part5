package org.construction.projetservice;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.construction.projetservice.service.ProjetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProjetServiceTest {

    @Mock
    private ProjetRepository projetRepository;

    @InjectMocks
    private ProjetService projetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProjet() {
        // Arrange
        Projet projet = new Projet();
        projet.setName("Test Project");
        projet.setBudget(10000);
        projet.setDescription("Test Description");

        when(projetRepository.save(any(Projet.class))).thenReturn(projet);

        // Act
        Projet result = projetService.addProjet(projet);

        // Assert
        assertNotNull(result);
        assertEquals("Test Project", result.getName());
        assertEquals(10000, result.getBudget());
        assertEquals("Test Description", result.getDescription());
        assertNotNull(result.getDateCreation());
        assertEquals(LocalDate.now(), result.getDateCreation());

        verify(projetRepository, times(1)).save(any(Projet.class));
    }

    @Test
    void testShowProjet() {
        // Arrange
        Projet projet1 = new Projet();
        projet1.setId(1);
        projet1.setName("Project 1");

        Projet projet2 = new Projet();
        projet2.setId(2);
        projet2.setName("Project 2");

        List<Projet> projets = Arrays.asList(projet1, projet2);

        when(projetRepository.findAll()).thenReturn(projets);

        // Act
        List<Projet> result = projetService.showProjet();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Project 1", result.get(0).getName());
        assertEquals("Project 2", result.get(1).getName());

        verify(projetRepository, times(1)).findAll();
    }
}