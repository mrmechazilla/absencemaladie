package com.example.FirstProject;

import com.example.FirstProject.entities.AbsenceMaladie;
import com.example.FirstProject.entities.AgentAdmin;
import com.example.FirstProject.entities.Collaborateur;
import com.example.FirstProject.entities.Utilisateur;
import com.example.FirstProject.repositories.AbsenceMaladieRepository;
import com.example.FirstProject.repositories.AgentAdminRepository;
import com.example.FirstProject.repositories.CollaborateurRepository;
import com.example.FirstProject.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private AbsenceMaladieRepository absenceMaladieRepository;

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@Autowired
	private AgentAdminRepository agentAdminRepository;


	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		AbsenceMaladie absenceMaladie1 = new AbsenceMaladie(1L,new Date(),new Date(),1,"satuts");
		AbsenceMaladie absenceMaladie2 = new AbsenceMaladie(2L,new Date(),new Date(),3,"satuts");
		AbsenceMaladie absenceMaladie3 = new AbsenceMaladie(3L,new Date(),new Date(),7,"satuts");
		AbsenceMaladie absenceMaladie4 = new AbsenceMaladie(4L,new Date(),new Date(),8,"satuts");
		AbsenceMaladie absenceMaladie5 = new AbsenceMaladie(5L,new Date(),new Date(),4,"satuts");

		Collection<AbsenceMaladie> absenceMaladieCollection = new ArrayList<>();
		absenceMaladieCollection.add(absenceMaladie1);
		absenceMaladieCollection.add(absenceMaladie3);
		absenceMaladieCollection.add(absenceMaladie2);

		absenceMaladieRepository.save(absenceMaladie1);
		absenceMaladieRepository.save(absenceMaladie2);
		absenceMaladieRepository.save(absenceMaladie3);
		absenceMaladieRepository.save(absenceMaladie4);
		absenceMaladieRepository.save(absenceMaladie5);

		Collaborateur collaborateur1 = new Collaborateur(1L, absenceMaladieCollection);
		Collaborateur collaborateur2 = new Collaborateur(2L,absenceMaladieCollection);
		Collaborateur collaborateur3 = new Collaborateur(3L,absenceMaladieCollection);
		Collaborateur collaborateur4 = new Collaborateur(4L,absenceMaladieCollection);


		AgentAdmin agentAdmin1 = new AgentAdmin(1L,absenceMaladieCollection);
		AgentAdmin agentAdmin2 = new AgentAdmin(2L,absenceMaladieCollection);
		AgentAdmin agentAdmin3 = new AgentAdmin(3L,absenceMaladieCollection);
		AgentAdmin agentAdmin4 = new AgentAdmin(4L,absenceMaladieCollection);


		utilisateurRepository.save(new Utilisateur(1L,"nom 1", "prenom 1", "email1@gmail.com", "1234"));
		utilisateurRepository.save(new Utilisateur(2L,"nom 2", "prenom 2", "email2@gmail.com", "1234"));
		utilisateurRepository.save(new Utilisateur(3L,"nom 3", "prenom 3", "email3@gmail.com", "1234"));

		collaborateurRepository.save(collaborateur1);
		collaborateurRepository.save(collaborateur2);
		collaborateurRepository.save(collaborateur3);
		collaborateurRepository.save(collaborateur4);

		agentAdminRepository.save(agentAdmin1);
		agentAdminRepository.save(agentAdmin2);
		agentAdminRepository.save(agentAdmin3);
		agentAdminRepository.save(agentAdmin4);





	}
}


