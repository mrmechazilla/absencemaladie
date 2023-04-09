package com.example.FirstProject.services;

import com.example.FirstProject.entities.AgentAdmin;
import com.example.FirstProject.repositories.AgentAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentAdminService {
    @Autowired
    private AgentAdminRepository agentAdminRepository;

    public void saveAgentAdmin(AgentAdmin agentAdmin){
        agentAdminRepository.save(agentAdmin);
    }

    public List<AgentAdmin> getAllAgentAdmin(){
        return agentAdminRepository.findAll();
    }

    public Optional<AgentAdmin> getAgentAdminById(Long id){
        return agentAdminRepository.findById(id);
    }
}
