package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByName(String name);

}
