package com.github.wikicode96.airline.repository;

import com.github.wikicode96.airline.entity.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Integer> {
}
