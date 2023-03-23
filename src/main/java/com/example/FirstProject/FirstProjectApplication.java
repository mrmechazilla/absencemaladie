package com.example.FirstProject;

import com.example.FirstProject.entities.Utilisateur;
import com.example.FirstProject.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication
public class FirstProjectApplication {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	public static void main(String[] args) {
		UtilisateurRepository.save(new Utilisateur(1L, "Youssef"));
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}


