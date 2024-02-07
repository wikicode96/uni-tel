package com.github.wikicode96.airline.service;

import com.github.wikicode96.airline.command.AirlineCommand;
import com.github.wikicode96.airline.dto.AirlineDTO;

import java.util.List;

public interface AirlineService {

    // CRUD
    void createAirline(AirlineCommand airline);
    AirlineDTO getAirlineByName(String name);
    List<AirlineDTO> getAllAirlines();
    void updateAirline(AirlineCommand airline);
    void deleteAirlineByName(AirlineCommand airline);
}
