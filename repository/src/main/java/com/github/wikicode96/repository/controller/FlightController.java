package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Flight;
import com.github.wikicode96.repository.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Flight> newFlight(@RequestBody Flight flight){
        Flight response = service.newFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "flight/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Flight> getFlightById(@PathVariable("id") int id){
        Flight response = service.getFlightById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> response = service.getAllFlights();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "flights/airline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Flight>> getAllFlightsByAirlineId(@PathVariable("id") int idAirline){
        List<Flight> response = service.getAllFlightsByAirlineId(idAirline);

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Flight> updateFlight(@RequestBody Flight flight){
        Flight response =  service.updateFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Flight> deleteFlight(@RequestBody Flight flight){
        Flight response =  service.deleteFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
