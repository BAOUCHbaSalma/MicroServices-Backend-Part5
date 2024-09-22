package org.construction.ressourceservice;

import org.construction.ressourceservice.model.Ressource;
import org.construction.ressourceservice.repository.RessourceRepository;
import org.construction.ressourceservice.service.RessourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RessourceServiceTest {

    @Mock
    private RessourceRepository ressourceRepository;

    @InjectMocks
    private RessourceService ressourceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRessource() {
        // Arrange
        Ressource ressource = new Ressource();
        ressource.setName("Test Resource");
        ressource.setQuantity(10);
        ressource.setInfoFornisseur("Test Supplier");
        ressource.setPicture("test_picture.jpg");

        when(ressourceRepository.save(any(Ressource.class))).thenReturn(ressource);

        // Act
        Ressource result = ressourceService.addRessource(ressource);

        // Assert
        assertNotNull(result);
        assertEquals("Test Resource", result.getName());
        assertEquals(10, result.getQuantity());
        assertEquals("Test Supplier", result.getInfoFornisseur());
        assertEquals("test_picture.jpg", result.getPicture());

        verify(ressourceRepository, times(1)).save(any(Ressource.class));
    }

    @Test
    void testShowAll() {
        // Arrange
        Ressource ressource1 = new Ressource();
        ressource1.setId(1);
        ressource1.setName("Resource 1");

        Ressource ressource2 = new Ressource();
        ressource2.setId(2);
        ressource2.setName("Resource 2");

        List<Ressource> ressources = Arrays.asList(ressource1, ressource2);

        when(ressourceRepository.findAll()).thenReturn(ressources);

        // Act
        List<Ressource> result = ressourceService.showAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Resource 1", result.get(0).getName());
        assertEquals("Resource 2", result.get(1).getName());

        verify(ressourceRepository, times(1)).findAll();
    }
}