package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project.entities.AbattementParametre;

public interface AbattementParametreRepository extends JpaRepository<AbattementParametre, Long>   {
    @Query("SELECT a FROM com.example.project.entities.AbattementParametre a WHERE a.Abattement.id=:id ")
    public AbattementParametre findByAbattement(String id);

    @Query("SELECT a FROM com.example.project.entities.Abattement a WHERE EXISTS (SELECT 1 FROM p.listabattementParametres ap WHERE ap.Abattement.id =:id)")
    public AbattementParametre findAbattementParametreByAbattement(String id);

    @Query("SELECT parametre FROM com.example.project.entities.AbatementParametre ap WHERE ap.abatement.id =: id")
    public AbattementParametre findParametreByAbattement(String id);
}
