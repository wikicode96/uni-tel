package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight newFlight(Flight flight);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    List<Flight> getAllFlightsByAirlineId(int idAirline);
    Flight updateFlight(Flight flight);
    Flight deleteFlight(Flight flight);
}
