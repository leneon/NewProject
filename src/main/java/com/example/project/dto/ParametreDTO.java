package com.example.project.dto;

public class ParametreDTO {
    private Long id;
    private String titre;
    private String type;
    private Float valeur;
    private String slug;

    
    public ParametreDTO(Long id, String titre, String type, Float valeur, String slug) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.valeur = valeur;
        this.slug = slug;
    }
    public ParametreDTO(Long id, String titre, String type, Float valeur) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.valeur = valeur;
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
    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    
}
