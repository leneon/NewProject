package com.example.project.dto;

import java.util.List;

import com.example.project.entities.Abattement;

public class AbattementObjectDTO {
    private Abattement abatttement;
    private List parametres;
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    private String heure;
    public AbattementObjectDTO() {
    }
    public Abattement getAbatttement() {
        return abatttement;
    }
    public void setAbatttement(Abattement abatttement) {
        this.abatttement = abatttement;
    }
    public List getParametres() {
        return parametres;
    }
    public void setParametres(List parametres) {
        this.parametres = parametres;
    }

    
}
