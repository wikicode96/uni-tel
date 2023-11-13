package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Flight;

public interface FlightService {

    Flight[] getAllFlights();
    void deleteFlight(Flight flight);
}
