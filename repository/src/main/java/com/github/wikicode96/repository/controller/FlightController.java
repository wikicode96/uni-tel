package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Flight;
import com.github.wikicode96.repository.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService service;

    // CRUD
    @PostMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Flight newFlight(Flight flight){
        return service.newFlight(flight);
    }

    @GetMapping(value = "flight/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Flight getFlightById(@PathVariable("id") int id){
        return service.getFlightById(id);
    }

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getAllFlights(){
        return service.getAllFlights();
    }

    @PutMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Flight updateFlight(Flight flight){
        return service.updateFlight(flight);
    }

    @DeleteMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Flight deleteFlight(Flight flight){
        return service.updateFlight(flight);
    }
}
