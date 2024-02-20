package com.example.project.dto;

import java.sql.Date;

public class AbattementDTO {
    private Long id;
    private ClientDTO client;
    private Date date;
    private Integer journee;
    private Double vente;
    private Double paiement;
    private Double soldeAVerser;
    private Double reg;
    private Double nonReg;
    private Float total;

    
    public AbattementDTO(Long id, ClientDTO client, Date date, Integer journee, Double vente, Double paiement,
            Double soldeAVerser, Double reg, Double nonReg, Float total) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.journee = journee;
        this.vente = vente;
        this.paiement = paiement;
        this.soldeAVerser = soldeAVerser;
        this.reg = reg;
        this.nonReg = nonReg;
        this.total = total;
    }
    public AbattementDTO() {
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
    public Integer getJournee() {
        return journee;
    }
    public void setJournee(Integer journee) {
        this.journee = journee;
    }
    public Double getVente() {
        return vente;
    }
    public void setVente(Double vente) {
        this.vente = vente;
    }
    public Double getPaiement() {
        return paiement;
    }
    public void setPaiement(Double paiement) {
        this.paiement = paiement;
    }
    public Double getSoldeAVerser() {
        return soldeAVerser;
    }
    public void setSoldeAVerser(Double soldeAVerser) {
        this.soldeAVerser = soldeAVerser;
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
    public Float getTotal() {
        return total;
    }
    public void setTotal(Float total) {
        this.total = total;
    }



    


    
}
