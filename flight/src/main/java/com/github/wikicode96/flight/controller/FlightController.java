package com.github.wikicode96.flight.controller;

import com.github.wikicode96.flight.entity.FlightEntity;
import com.github.wikicode96.flight.service.FlightService;
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
    ResponseEntity<FlightEntity> newFlight(@RequestBody FlightEntity flight){
        FlightEntity response = service.newFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "flight/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FlightEntity> getFlightById(@PathVariable("id") int id){
        FlightEntity response = service.getFlightById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FlightEntity>> getAllFlights(){
        List<FlightEntity> response = service.getAllFlights();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "flights/airline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FlightEntity>> getAllFlightsByAirlineId(@PathVariable("id") int idAirline){
        List<FlightEntity> response = service.getAllFlightsByAirlineId(idAirline);

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FlightEntity> updateFlight(@RequestBody FlightEntity flight){
        FlightEntity response =  service.updateFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FlightEntity> deleteFlight(@RequestBody FlightEntity flight){
        FlightEntity response =  service.deleteFlight(flight);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
