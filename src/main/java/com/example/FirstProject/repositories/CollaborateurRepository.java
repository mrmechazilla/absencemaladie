package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborateurRepository extends JpaRepository<Collaborateur,Long> {
    List<Collaborateur> findAllById(int id);
}
