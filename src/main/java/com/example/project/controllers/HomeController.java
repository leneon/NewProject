 package com.example.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/clients")
    public String clients(){
        return "clients";
    }
    @GetMapping("/agences")
    public String agences(){
        return "agences";
    }
    @GetMapping("/utilisateurs")
    public String utilisateurs(){
        return "utilisateurs";
    }
}
