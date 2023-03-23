package com.example.FirstProject.controllers;

import com.example.FirstProject.entities.Utilisateur;
import com.example.FirstProject.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/adduser")
    public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.addUser(utilisateur);
    }

    @GetMapping("/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUserById(id);
    }

    @GetMapping("/getallusers")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUsers();
    }

    // Other methods...
}
