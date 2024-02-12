package com.example.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Client;

@Repository
public interface clientRepository extends JpaRepository<Client, Long> {
    
}
