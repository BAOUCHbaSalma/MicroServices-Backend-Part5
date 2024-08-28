package org.construction.tacheservice.classe;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Projet {

    private Integer id;
    private String name;
    private String description;
    private LocalDate dateCreation;
    private LocalDate dateFin;
    private Integer budget;
}
