package com.example.FirstProject.services;

import com.example.FirstProject.entities.Utilisateur;
import com.example.FirstProject.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public void addUser(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> getUserById(Long id){

        return utilisateurRepository.findById(id);
    }
    public List<Utilisateur> getAllUsers(){

        return utilisateurRepository.findAll();
    }
    public void deleteUserById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Optional<Utilisateur> getUserByUsername(String email) {

        return utilisateurRepository.findByEmail(email);
    }
}
