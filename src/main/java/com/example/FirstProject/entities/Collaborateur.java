package com.example.FirstProject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@ToString
public class Collaborateur extends Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "collaborateur")
    private Collection<AbsenceMaladie> absenceMaladie;
}
