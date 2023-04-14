package fr.simplon.festivals.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.festivals.dao.FestivalDAO;
import fr.simplon.festivals.dao.impl.FestivalRepository;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FestivalController {

    @Autowired
    private FestivalRepository festivalRepository;

    @RequestMapping("/")
    public String accueil() {
        return "Accueil";
    }

    @RequestMapping("/AjouterFestival")
    public String Ajouterfestiva1(Model model) {
        model.addAttribute("festival", new Festival());
        return "AjouterFestival";
    }

    @RequestMapping("/EditerFestival")
    public String EditerFestival(Model model) {
        return "EditerFestival";
    }

    /* Au dessus simplement le retour des pages HTML */

    @GetMapping("/")
    String listeFestivals(Model model) {
        List<Festival> festivals;
        festivals = festivalDAO.getAllFestivals();
        model.addAttribute("festivals", festivals);
        // Convertissez la liste des festivals en JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String festivalsJson = "";
        try {
            festivalsJson = objectMapper.writeValueAsString(festivals);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("festivalsJson", festivalsJson);
        return "Accueil";
    }

    @Autowired
    private FestivalDAO festivalDAO;

    @PostMapping("/AjouterFestival") // Mapping POST pour enregistrer un festival
    public String saveFestival(@ModelAttribute Festival festival) {
        // Utiliser le DAO pour enregistrer le festival en base de données
        festivalDAO.saveFestival(festival.getNom(), festival.getVille(), festival.getLieu(),
                festival.getDebut(), festival.getFin(), festival.getLatitude(), festival.getLongitude());
        return "redirect:/"; // Rediriger vers la page d'accueil après l'enregistrement
    }


    @GetMapping("/EditerFestival/{id}")
    public String EditerFestival(@PathVariable("id") Long id, Model model) {
        model.addAttribute("festival", festivalRepository.findById(id).orElse(null));
        return "EditerFestival";
    }

    @PostMapping("/update/{id}")
    public String updateFestival(@PathVariable("id") Long id, Festival festival, Model model) {
        festival.setId(id);
        festivalRepository.save(festival);
        return "redirect:/";
    }

    @GetMapping("/festivals")
    @ResponseBody
    public List<Festival> getFestivals() {
        return festivalDAO.getAllFestivals();
    }
}
