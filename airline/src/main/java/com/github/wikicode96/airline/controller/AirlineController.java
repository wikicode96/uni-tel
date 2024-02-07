package com.github.wikicode96.airline.controller;

import com.github.wikicode96.airline.command.AirlineCommand;
import com.github.wikicode96.airline.dto.AirlineDTO;
import com.github.wikicode96.airline.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "airline")
public class AirlineController {

    @Autowired
    private AirlineService service;

    // CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createAirline(@RequestBody AirlineCommand airline){
        service.createAirline(airline);
        return ResponseEntity.ok("Airline created successfully");
    }

    @GetMapping(value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AirlineDTO> getAirlineByName(@PathVariable("name") String name){
        AirlineDTO response = service.getAirlineByName(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AirlineDTO>> getAllAirlines(){
        List<AirlineDTO> response = service.getAllAirlines();
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateAirline(@RequestBody AirlineCommand airline){
        service.updateAirline(airline);
        return ResponseEntity.ok("Airline updated successfully");
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteAirlineByName(@RequestBody AirlineCommand airline){
        service.deleteAirlineByName(airline);
        return ResponseEntity.ok("Airline deleted successfully");
    }
}
