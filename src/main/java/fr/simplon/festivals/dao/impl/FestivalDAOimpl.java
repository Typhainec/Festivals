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
    public void saveFestival(String nom, String ville, String lieu,  Date datedebut, Date datefin) {
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setville(ville);
        festival.setlieu(lieu);
        festival.setdatedebut(datedebut);
        festival.setdatefin(datefin);
        festivalRepository.save(festival);
    }

    @Override
    public void savefestival(String nom, String ville, String lieu, Date datedebut, Date datefin) {

    }
}

