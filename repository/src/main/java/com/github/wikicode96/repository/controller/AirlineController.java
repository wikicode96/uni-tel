package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Airline;
import com.github.wikicode96.repository.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirlineController {

    @Autowired
    private AirlineService service;

    // CRUD
    @PostMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Airline> newAirline(@RequestBody Airline airline){
        Airline response = service.newAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "airline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Airline> getAirlineById(@PathVariable("id") int id){
        Airline response = service.getAirlineById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "airlines", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Airline>> getAllAirlines(){
        List<Airline> response = service.getAllAirlines();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Airline> updateAirline(@RequestBody Airline airline){
        Airline response = service.updateAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Airline> deleteAirline(@RequestBody Airline airline){
        Airline response = service.deleteAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
