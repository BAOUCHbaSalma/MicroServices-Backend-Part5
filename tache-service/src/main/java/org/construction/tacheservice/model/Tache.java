package org.construction.tacheservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.construction.tacheservice.classe.Projet;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String description;
    @Column(name = "date_creation")
    private LocalDate dateCreation;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @Transient
    private Projet projet;
    @Column(name = "projet_id")
    private Integer projetId;

}
