package com.example.project.entities;

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

    
    
}
