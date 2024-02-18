package com.github.wikicode96.flight.repository;

import com.github.wikicode96.flight.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
    List<FlightEntity> findAllByAirlineName(String airlineName);
}
