package com.example.FirstProject.services;

import com.example.FirstProject.entities.Collaborateur;
import com.example.FirstProject.repositories.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollaborateurService {
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    public void saveCollaborateur(Collaborateur collaborateur){

        collaborateurRepository.save(collaborateur);
    }
    public List<Collaborateur> getAllCollaborateurs(){
        return collaborateurRepository.findAll();
    }
    public Optional<Collaborateur> getCollaborateurById(Long id){
        return collaborateurRepository.findById(id);
    }
}
