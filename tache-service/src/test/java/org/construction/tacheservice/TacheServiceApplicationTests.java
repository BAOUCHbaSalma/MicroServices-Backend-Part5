package org.construction.tacheservice;

import org.construction.tacheservice.model.EStatus;
import org.construction.tacheservice.model.Tache;
import org.construction.tacheservice.repository.TacheRepository;
import org.construction.tacheservice.service.TacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TacheServiceTest {

//    @Mock
//    private TacheRepository tacheRepository;
//
//    @InjectMocks
//    private TacheService tacheService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testAddTache() {
//        // Arrange
//        Integer projetId = 1;
//        Tache tache = new Tache();
//        tache.setDescription("Test Task");
//
//        when(tacheRepository.save(any(Tache.class))).thenAnswer(invocation -> {
//            Tache savedTache = invocation.getArgument(0);
//            savedTache.setId(1);
//            return savedTache;
//        });
//
//        // Act
//        Tache result = tacheService.addTache(projetId, tache);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(1, result.getId());
//        assertEquals("Test Task", result.getDescription());
//        assertEquals(projetId, result.getProjetId());
//        assertEquals(LocalDate.now(), result.getDateCreation());
//        assertEquals(EStatus.A_FAIRE, result.getStatus());
//
//        verify(tacheRepository, times(1)).save(any(Tache.class));
//    }
//
//    @Test
//    void testShowTaches() {
//        // Arrange
//        Integer projetId = 1;
//        Tache tache1 = new Tache();
//        tache1.setId(1);
//        tache1.setDescription("Task 1");
//        tache1.setProjetId(projetId);
//
//        Tache tache2 = new Tache();
//        tache2.setId(2);
//        tache2.setDescription("Task 2");
//        tache2.setProjetId(projetId);
//
//        List<Tache> taches = Arrays.asList(tache1, tache2);
//
//        when(tacheRepository.findAllByProjetId(projetId)).thenReturn(taches);
//
//        // Act
//        List<Tache> result = tacheService.showTaches(projetId);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertEquals("Task 1", result.get(0).getDescription());
//        assertEquals("Task 2", result.get(1).getDescription());
//        assertEquals(projetId, result.get(0).getProjetId());
//        assertEquals(projetId, result.get(1).getProjetId());
//
//        verify(tacheRepository, times(1)).findAllByProjetId(projetId);
//    }
}