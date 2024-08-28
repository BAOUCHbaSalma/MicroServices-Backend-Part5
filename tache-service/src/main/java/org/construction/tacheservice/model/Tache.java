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
    @Column
    private LocalDate dateCreation;
    @Column
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @Transient
    private Projet projet;
    @Column
    private Integer projetId;

}
