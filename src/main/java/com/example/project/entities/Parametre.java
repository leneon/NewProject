package com.example.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="parametres")
public class Parametre {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String titre;
    @Column
    private String type;
    @Column
    private Float valeur;
    public Parametre(long id, String titre, String type, Float valeur) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.valeur = valeur;
    }
    public Parametre() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
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


}
