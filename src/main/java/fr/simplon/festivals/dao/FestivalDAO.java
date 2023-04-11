package fr.simplon.festivals.dao;

import java.util.Date;

public interface FestivalDAO {
    void saveFestival(String nom, String ville, String lieu, Date datedebut, Date datefin);
}
