package com.example.FirstProject.services;

import com.example.FirstProject.entities.AppRole;
import com.example.FirstProject.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String userName,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
