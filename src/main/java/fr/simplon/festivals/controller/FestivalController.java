package fr.simplon.festivals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FestivalController {

    @RequestMapping("/")
    public String accueil() {
        return "Acceuil";
    }

    @RequestMapping("/AjouterFestival")
    public String festival() {
        return "AjouterFestival";
    }

    @RequestMapping("/EditerFestival")
    public String festivals() {
        return "EditerFestival";
    }
}
