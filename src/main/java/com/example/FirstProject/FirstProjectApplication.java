package com.example.FirstProject;

import com.example.FirstProject.dto.DTOAbsenceMaladie;
import com.example.FirstProject.entities.Collaborateur;
import com.example.FirstProject.entities.Document;
import com.example.FirstProject.entities.Utilisateur;
import com.example.FirstProject.repositories.CollaborateurRepository;
import com.example.FirstProject.repositories.UtilisateurRepository;
import com.example.FirstProject.services.AbsenceMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@SpringBootApplication

public class FirstProjectApplication implements CommandLineRunner {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@Autowired
	private AbsenceMaladieService absenceMaladieService;
	public static void main(String[] args) {

		SpringApplication.run(FirstProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		utilisateurRepository.save(new Utilisateur(1L,"youssef", "prenom 1", "youssef@capgemini.com", "1234"));
		utilisateurRepository.save(new Utilisateur(2L,"nom 2", "prenom 2", "email2@gmail.com", "1234"));
		utilisateurRepository.save(new Utilisateur(3L,"nom 3", "prenom 3", "email3@gmail.com", "1234"));
		collaborateurRepository.save(new Collaborateur(1L,null));
		collaborateurRepository.save(new Collaborateur(2L,null));
		collaborateurRepository.save(new Collaborateur(3L,null));
		collaborateurRepository.save(new Collaborateur(4L,null));
		Date datedebut = null;
		Date datefin = null;
		// convert date from String to Date

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		datedebut = dateFormat.parse("1999-04-07");

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		datefin = dateFormat1.parse("1999-04-20");

		//absenceMaladieService.saveAbsenceMaladie(4L, new DTOAbsenceMaladie(datedebut, datefin, 2));
	}
}


