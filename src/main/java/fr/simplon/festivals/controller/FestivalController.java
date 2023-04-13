package fr.simplon.festivals.controller;

import fr.simplon.festivals.dao.FestivalDAO;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FestivalController {

    @RequestMapping("/")
    public String accueil() {
        return "Accueil";
    }

    @RequestMapping("/AjouterFestival")
    public String festival(Model model) {
        model.addAttribute("festival", new Festival());
    return "AjouterFestival";
    }

    @RequestMapping("/EditerFestival")
    public String festivals() {
        return "EditerFestival";
    }

    @Autowired
    private FestivalDAO festivalDAO;

    @PostMapping("/AjouterFestival") // Mapping POST pour enregistrer un festival
    public String saveFestival(Festival festival) {
        // Utiliser le DAO pour enregistrer le festival en base de données
        festivalDAO.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLatitude(), festival.getLongitude());
        return "redirect:Accueil"; // Rediriger vers la page d'accueil après l'enregistrement
    }
}