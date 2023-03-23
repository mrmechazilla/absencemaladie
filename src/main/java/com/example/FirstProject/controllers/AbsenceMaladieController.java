package com.example.FirstProject.controllers;

import com.example.FirstProject.entities.AbsenceMaladie;
import com.example.FirstProject.services.AbsenceMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceMaladieController {

    @Autowired
    private AbsenceMaladieService absenceMaladieService;

    @PostMapping("/addabsencemaladie")
    public ResponseEntity<AbsenceMaladie> addAbsenceMaladie(@RequestBody AbsenceMaladie absenceMaladie) {
        AbsenceMaladie addedAbsenceMaladie = absenceMaladieService.addAbsenceMaladie(absenceMaladie);
        return new ResponseEntity<>(addedAbsenceMaladie, HttpStatus.CREATED);
    }

    @GetMapping("/getallabsencemaladie")
    public ResponseEntity<List<AbsenceMaladie>> getAllAbsencesMaladies() {
        List<AbsenceMaladie> absencesMaladies = absenceMaladieService.getAbsenceMaladie();
        return new ResponseEntity<>(absencesMaladies, HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<AbsenceMaladie> getAbsenceMaladieById(@PathVariable String status) {
        AbsenceMaladie absenceMaladie = (AbsenceMaladie) absenceMaladieService.getAbsenceMaladieByStatus(status);
        return new ResponseEntity<>(absenceMaladie, HttpStatus.OK);
    }
}