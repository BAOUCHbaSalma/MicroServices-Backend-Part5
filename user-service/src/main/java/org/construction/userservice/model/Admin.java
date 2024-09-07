package org.construction.userservice.model;

import org.construction.userservice.enums.Erole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Admin() {
        this.setErole(Erole.ADMIN);
    }

}
