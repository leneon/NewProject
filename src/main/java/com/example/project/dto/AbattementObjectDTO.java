package com.example.project.dto;

import java.util.Date;


public class AbattementObjectDTO {
    private Long id;
    private ClientDTO client;
    private Date date;
    private Double vente;
    private Double solde_a_verser;
    private Double paiement;
    private Double reg;
    private Double nonReg;
    private Double total;

    private Boolean retards;
    private Boolean moins_verses;
    private Boolean moins_verses_avec_retard;
    private Boolean non_verse;
    private String heure;

    public AbattementObjectDTO() {
    }


    public Boolean getRetards() {
        return retards;
    }

    public void setRetards(Boolean retards) {
        this.retards = retards;
    }

    public Boolean getMoins_verses() {
        return moins_verses;
    }


    public void setMoins_verses(Boolean moins_verses) {
        this.moins_verses = moins_verses;
    }


    public Boolean getMoins_verses_avec_retard() {
        return moins_verses_avec_retard;
    }


    public void setMoins_verses_avec_retard(Boolean moins_verse_avec_retard) {
        this.moins_verses_avec_retard = moins_verse_avec_retard;
    }


    public Boolean getNon_verse() {
        return non_verse;
    }


    public void setNon_verse(Boolean non_verse) {
        this.non_verse = non_verse;
    }


    public String getHeure() {
        return heure;
    }


    public void setHeure(String heure) {
        this.heure = heure;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public ClientDTO getClient() {
        return client;
    }


    public void setClient(ClientDTO client) {
        this.client = client;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Double getVente() {
        return vente;
    }


    public void setVente(Double vente) {
        this.vente = vente;
    }


    public Double getSolde_a_verser() {
        return solde_a_verser;
    }


    public void setSolde_a_verser(Double solde_a_verser) {
        this.solde_a_verser = solde_a_verser;
    }


    public Double getPaiement() {
        return paiement;
    }


    public void setPaiement(Double paiement) {
        this.paiement = paiement;
    }


    public Double getReg() {
        return reg;
    }


    public void setReg(Double reg) {
        this.reg = reg;
    }


    public Double getNonReg() {
        return nonReg;
    }


    public void setNonReg(Double nonReg) {
        this.nonReg = nonReg;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }


    
}
