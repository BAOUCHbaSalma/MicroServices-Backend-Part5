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
    private Integer quantity;
    @Column
    private String picture;
    @Column
    private String infoFornisseur;
    @Transient
    private Tache tache;
    @Column
    private Integer tacheId;
}
