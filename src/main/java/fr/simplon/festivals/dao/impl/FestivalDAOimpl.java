package fr.simplon.festivals.dao.impl;

import fr.simplon.festivals.dao.FestivalDAO;
import fr.simplon.festivals.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository

public class FestivalDAOimpl implements FestivalDAO {

    @Autowired
    private fr.simplon.festivals.dao.impl.FestivalRepository festivalRepository;

    @Override
    public void saveFestival(String nom, String ville, String lieu,  Date debut, Date fin, Double latitude, Double longitude) {
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setVille(ville);
        festival.setLieu(lieu);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setLatitude(latitude);
        festival.setLongitude(longitude);
        festivalRepository.save(festival);
    }
}

