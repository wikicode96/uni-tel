package com.github.wikicode96.flight.service;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.FlightDTO;

import java.util.List;

public interface FlightService {
    void createFlight(FlightCommand flight);
    FlightDTO getFlightById(int id);
    List<FlightDTO> getAllFlights();
    List<FlightDTO> getAllFlightsByAirline(String airline);
    void updateFlightById(FlightCommand flight);
    void deleteFlightById(FlightCommand flight);
}
