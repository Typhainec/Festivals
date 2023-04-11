package fr.simplon.festivals.dao;

import java.util.Date;

public interface FestivalDAO {
    void saveFestival(String nom, String ville, String lieu,  Date debut, Date fin, Double latitude, Double longitude);

}
