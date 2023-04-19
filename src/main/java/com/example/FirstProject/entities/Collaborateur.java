package com.example.FirstProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "collaborateur", fetch = FetchType.EAGER)
    private Collection<AbsenceMaladie> absenceMaladie;
}
