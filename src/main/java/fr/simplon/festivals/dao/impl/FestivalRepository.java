package fr.simplon.festivals.dao.impl;

import fr.simplon.festivals.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FestivalRepository extends JpaRepository<Festival, Long> {
}
