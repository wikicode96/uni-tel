package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Airline;
import com.github.wikicode96.repository.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirlineController {

    @Autowired
    private AirlineService service;

    // CRUD
    @PostMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Airline newAirline(@RequestBody Airline airline){
        return service.newAirline(airline);
    }

    @GetMapping(value = "airline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Airline getAirlineById(@PathVariable("id") int id){
        return service.getAirlineById(id);
    }

    @GetMapping(value = "airlines", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Airline> getAllAirlines(){
        return service.getAllAirlines();
    }

    @PutMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Airline updateAirline(@RequestBody Airline airline){
        return service.updateAirline(airline);
    }

    @DeleteMapping(value = "airline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Airline deleteAirline(@RequestBody Airline airline){
        return service.deleteAirline(airline);
    }
}
