package com.example.FirstProject.services;

import com.example.FirstProject.dto.DTOAbsenceMaladie;
import com.example.FirstProject.entities.AbsenceMaladie;
import com.example.FirstProject.entities.Collaborateur;
import com.example.FirstProject.entities.Document;
import com.example.FirstProject.repositories.AbsenceMaladieRepository;
import com.example.FirstProject.repositories.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceMaladieService {
    private final DocumentService documentService;
    private final AbsenceMaladieRepository absenceMaladieRepository;
    private final CollaborateurRepository collaborateurRepository;
    @Autowired
    public AbsenceMaladieService(DocumentService documentService, AbsenceMaladieRepository absenceMaladieRepository, CollaborateurRepository colabRepository) {
        this.documentService = documentService;
        this.absenceMaladieRepository = absenceMaladieRepository;
        this.collaborateurRepository = colabRepository;
    }

    public void saveAbsenceMaladie(Long idColab,
                                   MultipartFile multipartFiles,
                                   DTOAbsenceMaladie dtoAbsenceMaladie) throws Exception {
        Document document =  documentService.uploadDocument(multipartFiles);
        Optional<Collaborateur> colab = collaborateurRepository.findById(idColab);
        Collaborateur collaborateur1 = colab.get();
        System.out.println(collaborateur1);

        AbsenceMaladie absenceMaladie = new AbsenceMaladie();
        absenceMaladie.setDocument(document);
        absenceMaladie.setCollaborateur(collaborateur1);
        absenceMaladie.setDateDebut(dtoAbsenceMaladie.getDateDebut());
        absenceMaladie.setDateFin(dtoAbsenceMaladie.getDateFin());
        absenceMaladie.setNombreJours(dtoAbsenceMaladie.getNombreJours());
        System.out.println(absenceMaladie);

        absenceMaladieRepository.save(absenceMaladie);
}

    public List<AbsenceMaladie> findAllAbsenceMaladie(){
        return absenceMaladieRepository.findAll();
    }

    public void deleteAbsenceMaladie(Long id){
        absenceMaladieRepository.deleteById(id);
    }

    public AbsenceMaladie updateStatus(Long id, String status) {
        AbsenceMaladie absenceMaladie = absenceMaladieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        absenceMaladie.setStatus(status);
        return absenceMaladieRepository.save(absenceMaladie);
    }
}