package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.AbattementDTO;
import com.example.project.entities.Abattement;
import com.example.project.repositories.AbattementRepository;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbattementService{

    private final AbattementRepository abattementRepository;
    @Autowired
    public AbattementService(AbattementRepository abattementRepository) {
        this.abattementRepository = abattementRepository;
    }

    public List<Abattement> getAllAbattements() {
        return abattementRepository.findAll();
    }
       public List<Abattement> getAllAbattementsDTO() {
        return this.getAllAbattements();
        // return this.getAllAbattements().stream()
        //         .map(this::mappedEntityToDTO)
        //         .collect(Collectors.toList());
    }

    public Abattement getAbattementById(Long id) {
        return abattementRepository.findById(id).orElse(null);
    }

    public Abattement createAbattement(Abattement abattement) {
        return abattementRepository.save(abattement);
    }

    public Abattement updateAbattement(Long id, Abattement abattement) {
        if (abattementRepository.existsById(id)) {
            abattement.setId(id);
            return abattementRepository.save(abattement);
        }
        return null;
    }

    public void deleteAbattement(Long id) {
        abattementRepository.deleteById(id);
    }

    /**
     * @param param
     * @return
     */
    // public AbattementDTO mappedEntityToDTO(Abattement param){
    //     if(param==null)
    //         return null;
    //     AbattementDTO abattementDTO = new AbattementDTO();
    //     abattementDTO.setId(param.getId());
    //     abattementDTO.setSlug(this.format(param.getTitre().toLowerCase().replaceAll("\\s", "_")));
    //     abattementDTO.setTitre(param.getTitre());
    //     abattementDTO.setType(param.getType());
    //     abattementDTO.setValeur(param.getValeur());

    //     return abattementDTO;            
    // }

    public String format(String str){
       return  Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
