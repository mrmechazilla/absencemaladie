package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.AbsenceMaladie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AbsenceMaladieRepository extends JpaRepository<AbsenceMaladie, Long> {
    List<AbsenceMaladie> findByStatus(String status);
    Optional<AbsenceMaladie> findById(Long id);

    List<AbsenceMaladie> findAll();
}
