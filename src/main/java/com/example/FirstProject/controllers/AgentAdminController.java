package com.example.FirstProject.controllers;

import com.example.FirstProject.entities.AgentAdmin;
import com.example.FirstProject.services.AgentAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agentAdmin")
public class AgentAdminController {
    @Autowired
    private AgentAdminService agentAdminService;
    @PostMapping("/addAgentAdmin")
    public String addAgentAdmin(@RequestBody AgentAdmin agentAdmin){
        agentAdminService.saveAgentAdmin(agentAdmin);
        return "enregistré avec succé";
    }
    @GetMapping("/getAllAgentAdmin")
    public List<AgentAdmin> getAllAgentAdmin(){
        return agentAdminService.getAllAgentAdmin();
    }
    @GetMapping("/getAgentAdminById/{id}")
    public Optional<AgentAdmin> getAgentAdminById(@PathVariable Long id){
        return agentAdminService.getAgentAdminById(id);
    }
}
