package com.example.project.resources;

import com.example.project.dto.*;
import com.example.project.services.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class projectResource {

    @Autowired
    private AgenceService agenceService;

    @GetMapping("/agence/liste")
    public ResponseEntity<HashMap<String, Object>> listeAgences(){
         
        HashMap<String, Object> model = new HashMap<>();
        model.put("listeAgences", this.agenceService.listeAgences());
        return ResponseEntity.accepted().body(model);
    }
    
}
