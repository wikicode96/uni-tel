package com.github.wikicode96.repository.repository;

import com.github.wikicode96.repository.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Custom method to get flights by airline id
    @Query("SELECT f FROM Flight f WHERE f.idAirline = :idAirline")
    List<Flight> findByAirlineId(int idAirline);
}
