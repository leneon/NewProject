package com.example.project.dto;

public class AbattementParametreDTO {
    private Long id;
    private String abattement;
    private String parametre;
    private String valeur;
    private Double montantAbattement;
    
    public AbattementParametreDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAbattement() {
        return abattement;
    }
    public void setAbattement(String abattement) {
        this.abattement = abattement;
    }
    public String getParametre() {
        return parametre;
    }
    public void setParametre(String parametre) {
        this.parametre = parametre;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public Double getMontantAbattement() {
        return montantAbattement;
    }
    public void setMontantAbattement(Double montantAbattement) {
        this.montantAbattement = montantAbattement;
    }
    
    
}
