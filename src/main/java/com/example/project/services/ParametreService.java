package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Parametre;
import com.example.project.repositories.ParametreRepository;

import java.util.List;

@Service
public class ParametreService {

    private final ParametreRepository parametreRepository;

    @Autowired
    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }

    public Parametre getParametreById(Long id) {
        return parametreRepository.findById(id).orElse(null);
    }

    public Parametre createParametre(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public Parametre updateParametre(Long id, Parametre parametre) {
        if (parametreRepository.existsById(id)) {
            parametre.setId(id);
            return parametreRepository.save(parametre);
        }
        return null;
    }

    public void deleteParametre(Long id) {
        parametreRepository.deleteById(id);
    }
}
