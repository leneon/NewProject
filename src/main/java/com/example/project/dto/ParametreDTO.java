package com.example.project.dto;

public class ParametreDTO {
    private Long id;
    private String titre;
    private String type;
    private Float valeur;
    private Double montant;

    public ParametreDTO(Long id, String titre, String type, Float valeur, Double montant) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.valeur = valeur;
        this.montant = montant;
    }
    public ParametreDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Float getValeur() {
        return valeur;
    }
    public void setValeur(Float float1) {
        this.valeur = float1;
    }
    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    
}
