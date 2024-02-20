package com.example.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.entities.Parametre;
import com.example.project.services.ParametreService;

import java.util.List;

@RestController
@RequestMapping("/parametres")
public class ParametreRessource {

    private final ParametreService parametreService;

    @Autowired
    public ParametreRessource(ParametreService parametreService) {
        this.parametreService = parametreService;
    }

    @GetMapping
    public ResponseEntity<List<Parametre>> getAllParametres() {
        List<Parametre> parametres = parametreService.getAllParametres();
        return new ResponseEntity<>(parametres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parametre> getParametreById(@PathVariable("id") Long id) {
        Parametre parametre = parametreService.getParametreById(id);
        if (parametre != null) {
            return new ResponseEntity<>(parametre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Parametre> createParametre(@RequestBody Parametre parametre) {
        Parametre createdParametre = parametreService.createParametre(parametre);
        return new ResponseEntity<>(createdParametre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parametre> updateParametre(@PathVariable("id") Long id, @RequestBody Parametre parametre) {
        Parametre updatedParametre = parametreService.updateParametre(id, parametre);
        if (updatedParametre != null) {
            return new ResponseEntity<>(updatedParametre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable("id") Long id) {
        parametreService.deleteParametre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
