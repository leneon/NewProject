package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.ParametreDTO;
import com.example.project.entities.Parametre;
import com.example.project.repositories.ParametreRepository;

@Service
public class ParametreService {

    private final ParametreRepository parametreRepository;

    @Autowired
    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }

    public Parametre getParametreById(Long id) {
        Parametre param = parametreRepository.findById(id).orElse(null);
        if(param !=null)
            this.mappedEntityToDTO(param);
        return null;
    }

    public Parametre createParametre(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public Parametre updateParametre(Long id, Parametre parametre) {
        if (parametreRepository.existsById(id)) {
           parametre.setId(id);
            return parametreRepository.save(parametre);
        }
        return null;
    }

    public void deleteParametre(Long id) {
        parametreRepository.deleteById(id);
    }

    public List<ParametreDTO> listeParametres() {
        List<ParametreDTO> parametreDTOList = new ArrayList<>();
    
        this.parametreRepository.findAll().forEach(parametre -> {
            parametreDTOList.add(mappedEntityToDTO(parametre));
        });
    
        return parametreDTOList;
    }
    
    

    public ParametreDTO mappedEntityToDTO(Parametre parametre){
        if(parametre==null)
            return null;

            ParametreDTO  parametreDTO = new ParametreDTO();

        parametreDTO.setId(parametre.getId());
        parametreDTO.setTitre(parametre.getTitre());
        parametreDTO.setType(parametre.getType());
        parametreDTO.setValeur(parametre.getValeur());
        parametreDTO.setMontant(parametre.getMontant());

        return parametreDTO;
    }



}
