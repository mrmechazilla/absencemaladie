package com.example.FirstProject.controllers;

import com.example.FirstProject.entities.Collaborateur;
import com.example.FirstProject.services.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/collaborateur")
public class CollaborateurController {
    //nouhaila
    @Autowired
    private CollaborateurService collaborateurService;
    @PostMapping("/addCollaborateur")
    public String addCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.saveCollaborateur(collaborateur);
        return "collaborateur enregistré avec succé";
    }
    @GetMapping("/allCollaborateur")
    public List<Collaborateur> getAllCollaborateur(){
        return collaborateurService.getAllCollaborateurs();
    }
    @GetMapping("/getCollaborateurById/{id}")
    public Optional<Collaborateur> getCollaborateurById(@PathVariable Long id){
        return collaborateurService.getCollaborateurById(id);
    }
}
