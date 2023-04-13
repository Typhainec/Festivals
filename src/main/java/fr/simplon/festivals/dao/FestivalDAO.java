package fr.simplon.festivals.dao;

import fr.simplon.festivals.entity.Festival;

import java.util.Date;
import java.util.List;


public interface FestivalDAO {
    void saveFestival(String nom, String ville, String lieu, Date debut, Date fin, Double latitude, Double longitude);

    List<Festival> getAllFestivals();

    Festival getFestivalById(Long id);
}
