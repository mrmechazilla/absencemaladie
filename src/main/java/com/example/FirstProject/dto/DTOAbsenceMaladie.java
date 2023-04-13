package com.example.FirstProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@ToString
public class DTOAbsenceMaladie {
    private Date dateDebut;
    private Date dateFin;
    private int nombreJours;
}