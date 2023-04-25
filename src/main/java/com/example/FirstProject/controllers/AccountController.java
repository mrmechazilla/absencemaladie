package com.example.FirstProject.controllers;

import com.example.FirstProject.entities.AppRole;
import com.example.FirstProject.entities.AppUser;
import com.example.FirstProject.services.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(path="/users")
    public List<AppUser> appUsers(){

        return accountService.listUsers();
    }



    @PostMapping(path="/users")
    public AppUser saveUser(@RequestBody AppUser appUser ) {
        System.out.println("gggggggggggg");

        return accountService.addNewUser(appUser);

    }



    @PostMapping(path="/roles")
    public AppRole saveRole(@RequestBody AppRole appRole ) {
        return accountService.addNewRole(appRole);

    }

    @PostMapping(path="/addRoleToUser")
    public void saveRole(@RequestBody RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());

    }

    @Data
    class RoleUserForm{
        private String username;
        private String roleName;

    }
}
