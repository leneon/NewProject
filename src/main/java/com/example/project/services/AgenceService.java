package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.AgenceDTO;
import com.example.project.entities.Agence;
import com.example.project.repositories.AgenceRepository;

@Service
public class AgenceService {
    @Autowired
    public AgenceRepository agenceRepository;

    public List<AgenceDTO> listeAgences() {
        List<AgenceDTO> agenceDTOList = new ArrayList<>();
    
        this.agenceRepository.findAll().forEach(agence -> {
            agenceDTOList.add(mappedEntityToDTO(agence));
        });
    
        return agenceDTOList;
    }
    
    

    public AgenceDTO mappedEntityToDTO(Agence agence){
        if(agence==null)
            return null;

        AgenceDTO  agenceDTO = new AgenceDTO();

        agenceDTO.setId(agence.getId());
        agenceDTO.setNom(agence.getNom());
        agenceDTO.setAdresse(agence.getAdresse());
        agenceDTO.setVille(agence.getVille());
        agenceDTO.setLocalisation(agence.getLocalisation());

        return agenceDTO;
    }
}
