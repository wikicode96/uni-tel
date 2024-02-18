package com.github.wikicode96.flight.controller;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createFlight(@RequestBody FlightCommand flight){
        service.createFlight(flight);
        return ResponseEntity.ok("Flight created successfully");
    }

    @GetMapping(params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FlightDTO> getFlightById(@RequestParam("id") int id){
        FlightDTO response = service.getFlightById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FlightDTO>> getAllFlights(){
        List<FlightDTO> response = service.getAllFlights();
        return ResponseEntity.ok(response);
    }

    @GetMapping(params = "airline", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FlightDTO>> getAllFlightsByAirline(@RequestParam("airline") String airline){
        List<FlightDTO> response = service.getAllFlightsByAirline(airline);
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateFlight(@RequestBody FlightCommand flight){
        service.updateFlightById(flight);
        return ResponseEntity.ok("Flight updated successfully");
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteFlight(@RequestBody FlightCommand flight){
        service.deleteFlightById(flight);
        return ResponseEntity.ok("Flight deleted successfully");
    }
}
