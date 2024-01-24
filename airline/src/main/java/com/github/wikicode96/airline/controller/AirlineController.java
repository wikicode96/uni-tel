package com.github.wikicode96.airline.controller;

import com.github.wikicode96.airline.entity.AirlineEntity;
import com.github.wikicode96.airline.service.AirlineService;
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
    ResponseEntity<AirlineEntity> newAirline(@RequestBody AirlineEntity airline){
        AirlineEntity response = service.newAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "airline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AirlineEntity> getAirlineById(@PathVariable("id") int id){
        AirlineEntity response = service.getAirlineById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "airlines", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AirlineEntity>> getAllAirlines(){
        List<AirlineEntity> response = service.getAllAirlines();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AirlineEntity> updateAirline(@RequestBody AirlineEntity airline){
        AirlineEntity response = service.updateAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AirlineEntity> deleteAirline(@RequestBody AirlineEntity airline){
        AirlineEntity response = service.deleteAirline(airline);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
