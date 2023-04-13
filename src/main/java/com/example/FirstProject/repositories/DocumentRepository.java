package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
