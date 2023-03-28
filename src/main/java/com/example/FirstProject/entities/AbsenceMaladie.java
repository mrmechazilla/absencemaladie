package com.example.FirstProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AbsenceMaladie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Integer nombreJours;
    private String status;
    @ManyToOne
    private Collaborateur collaborateur;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AgentAdmin> agentAdmins;

    public AbsenceMaladie(long id, Date date_debut, Date date_fin, int nombreJours, String satuts) {
        this.id = id;
        this.dateDebut = date_debut;
        this.dateFin = date_fin;
        this.nombreJours = nombreJours;
        this.status = satuts;
    }
}
