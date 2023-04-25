package com.example.FirstProject.repositories;

import com.example.FirstProject.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByName(String name);
}
