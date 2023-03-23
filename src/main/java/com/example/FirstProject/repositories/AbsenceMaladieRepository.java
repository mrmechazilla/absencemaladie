package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.AbsenceMaladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbsenceMaladieRepository extends JpaRepository<AbsenceMaladie, Long> {
    List<AbsenceMaladie> findByStatus(String status);
}
