package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Airline;

import java.util.List;

public interface AirlineService {

    // CRUD
    Airline newAirline(Airline airline);
    Airline getAirlineById(int id);
    List<Airline> getAllAirlines();
    Airline updateAirline(Airline airline);
    Airline deleteAirline(Airline airline);
}
