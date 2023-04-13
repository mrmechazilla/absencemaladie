package com.example.FirstProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@ToString
public class AbsenceMaladie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private Integer nombreJours;
    private String status;
    @ManyToOne
    @JoinColumn(name = "colabId")
    private Collaborateur collaborateur;

    @OneToOne
    private Document document;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AgentAdmin> agentAdmins;
}
