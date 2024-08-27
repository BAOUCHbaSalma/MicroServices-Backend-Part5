package org.construction.ressourceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.construction.ressourceservice.classe.Tache;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String picture;
    @Transient
    private Tache tache;
    @Column
    private Integer tacheId;
}
