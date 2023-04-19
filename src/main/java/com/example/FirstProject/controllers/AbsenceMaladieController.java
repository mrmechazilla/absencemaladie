package com.example.FirstProject.controllers;

import com.example.FirstProject.dto.DTOAbsenceMaladie;
import com.example.FirstProject.entities.AbsenceMaladie;
import com.example.FirstProject.services.AbsenceMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/absencemaladie")
public class AbsenceMaladieController {
    @Autowired
    private AbsenceMaladieService absenceMaladieService;
    @PostMapping("/save")
    public void saveAbsenceMaladie(@RequestParam("id") Long idColab,
                                   @RequestParam("nombreJours") Integer nombreJours,
                                   @RequestParam("dateDebut") String dateDebut,
                                   @RequestParam("dateFin") String dateFin,
                                   @RequestParam("document") MultipartFile multipartFiles) throws Exception {
        DTOAbsenceMaladie dtoAbsenceMaladie = new DTOAbsenceMaladie();

        Date datedebut = null;
        Date datefin = null;
        // convert date from String to Date

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datedebut = dateFormat.parse(dateDebut);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        datefin = dateFormat1.parse(dateFin);

        dtoAbsenceMaladie.setDateDebut(datedebut);
        dtoAbsenceMaladie.setDateFin(datefin);
        dtoAbsenceMaladie.setNombreJours(nombreJours);
        System.out.println(idColab);
        System.out.println(dtoAbsenceMaladie);
        String filename = StringUtils.cleanPath(Objects.requireNonNull(multipartFiles.getOriginalFilename()));
        System.out.println(filename);
        absenceMaladieService.saveAbsenceMaladie(idColab, multipartFiles, dtoAbsenceMaladie);
    }

    @GetMapping("/getAllAbsenceMaladie")
    public List<AbsenceMaladie> findAllAbsenceMaladie(){
        return absenceMaladieService.findAllAbsenceMaladie();
    }

    @DeleteMapping("/{id}")
    public void deleteAbsenceMaladie(@PathVariable Long id) {

        absenceMaladieService.deleteAbsenceMaladie(id);
    }
    @PatchMapping("/{id}")
    public AbsenceMaladie updateAbsenceMaladie(@PathVariable Long id, @RequestParam String status){
        return absenceMaladieService.updateStatus(id, status);
    }

}