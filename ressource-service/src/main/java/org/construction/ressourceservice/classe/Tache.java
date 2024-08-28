package org.construction.ressourceservice.classe;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Tache {

    private Integer id;
    private String description;
    private LocalDate dateCreation;
    private LocalDate dateFin;
    private EStatus status;
    private Integer projetId;
}
