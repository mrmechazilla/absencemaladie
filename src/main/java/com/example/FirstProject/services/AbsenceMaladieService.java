package com.example.FirstProject.services;

import com.example.FirstProject.entities.AbsenceMaladie;
import com.example.FirstProject.repositories.AbsenceMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceMaladieService {
    @Autowired
    private AbsenceMaladieRepository absenceMaladieRepository;

    public AbsenceMaladie addAbsenceMaladie(AbsenceMaladie absenceMaladie){
        absenceMaladieRepository.save(absenceMaladie);
        return absenceMaladie;
    }

    public List<AbsenceMaladie> getAbsenceMaladieByStatus(String status){
        return absenceMaladieRepository.findByStatus(status);
    }

    public List<AbsenceMaladie> getAbsenceMaladie(){
        return absenceMaladieRepository.findAll();
    }
}
