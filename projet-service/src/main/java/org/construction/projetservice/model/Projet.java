package org.construction.projetservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "date_creation")
    private LocalDate dateCreation;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Column
    private Integer budget;

}
