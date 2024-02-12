package com.example.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    
}
