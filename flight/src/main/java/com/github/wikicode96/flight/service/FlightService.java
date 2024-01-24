package com.github.wikicode96.flight.service;

import com.github.wikicode96.flight.entity.FlightEntity;

import java.util.List;

public interface FlightService {
    FlightEntity newFlight(FlightEntity flight);
    FlightEntity getFlightById(int id);
    List<FlightEntity> getAllFlights();
    List<FlightEntity> getAllFlightsByAirlineId(int idAirline);
    FlightEntity updateFlight(FlightEntity flight);
    FlightEntity deleteFlight(FlightEntity flight);
}
