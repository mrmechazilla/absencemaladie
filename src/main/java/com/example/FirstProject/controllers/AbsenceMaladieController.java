package com.example.FirstProject.controllers;

import com.example.FirstProject.dto.DTOAbsenceMaladie;
import com.example.FirstProject.services.AbsenceMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/absencemaladie")
public class AbsenceMaladieController {
    @Autowired
    private AbsenceMaladieService absenceMaladieService;
    // @RequestParam("dateDebut") Date dateDebut,
    // @RequestParam("dateFin") Date dateFin,
    @PostMapping(path = "/save")
    public void saveAbsenceMaladie(@RequestParam("id") Long idColab,
                                   @RequestParam("nombreJours") Integer nombreJours,
                                   @RequestParam("document") MultipartFile multipartFiles) throws Exception {
        DTOAbsenceMaladie dtoAbsenceMaladie = new DTOAbsenceMaladie();
        //dtoAbsenceMaladie.setDateDebut(dateDebut);
        //dtoAbsenceMaladie.setDateFin(dateFin);
        dtoAbsenceMaladie.setNombreJours(nombreJours);
        System.out.println(idColab);
        System.out.println(dtoAbsenceMaladie);
        String filename = StringUtils.cleanPath(Objects.requireNonNull(multipartFiles.getOriginalFilename()));
        System.out.println(filename);
        absenceMaladieService.saveAbsenceMaladie(idColab, multipartFiles, dtoAbsenceMaladie); //

    }
}