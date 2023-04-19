package com.example.FirstProject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE) // the format is yyyy-MM-dd
    private Date dateFin;
    private Integer nombreJours;
    private String status;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "colabId")
    private Collaborateur collaborateur;


    @JsonIgnore
    @OneToOne
    private Document document;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AgentAdmin> agentAdmins;


    public void setStatus(String status) {
        if (status.equals("En cours") || status.equals("Acceptée")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
}
