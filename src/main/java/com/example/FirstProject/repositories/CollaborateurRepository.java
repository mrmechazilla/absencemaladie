package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {
}
