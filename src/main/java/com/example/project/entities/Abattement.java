package com.example.project.entities;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abattements")
public class Abattement {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private Client titre;

    @Column
    private Date date;

    @Column
    private Integer journee;

    @Column
    private Double vente;

    @Column
    private Double paiement;

    @Column(name = "solde_a_verser")
    private Double soldeAVerser;

    @Column
    private Double reg;

    @Column(name="non_reg")
    private Double nonReg;

    public Abattement(long id, Client titre, Date date, Integer journee, Double vente, Double paiement,
            Double soldeAVerser, Double reg, Double nonReg) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.journee = journee;
        this.vente = vente;
        this.paiement = paiement;
        this.soldeAVerser = soldeAVerser;
        this.reg = reg;
        this.nonReg = nonReg;
    }

    public Abattement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getTitre() {
        return titre;
    }

    public void setTitre(Client titre) {
        this.titre = titre;
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
    

}
