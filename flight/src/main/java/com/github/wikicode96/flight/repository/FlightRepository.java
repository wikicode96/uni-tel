package com.github.wikicode96.flight.repository;

import com.github.wikicode96.flight.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {

    // Custom method to get flights by airline id
    @Query("SELECT f FROM FlightEntity f WHERE f.airline.id = :idAirline")
    List<FlightEntity> findByAirlineId(Long idAirline);
}
