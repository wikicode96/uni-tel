package com.github.wikicode96.costumer.controller;

import com.github.wikicode96.costumer.command.CreateCostummerCommand;
import com.github.wikicode96.costumer.command.DeleteCostummerCommand;
import com.github.wikicode96.costumer.command.UpdateCostumerCommand;
import com.github.wikicode96.costumer.dto.CostumerDTO;
import com.github.wikicode96.costumer.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "costumer")
@RestController
public class CostumerController {

    @Autowired
    private CostumerService service;

    // CRUD
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createCostumer(@RequestBody CreateCostummerCommand costumer){
        service.createCostumer(costumer);
        return ResponseEntity.ok("Costumer created successfully");
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CostumerDTO> getCostumerById(@PathVariable("id") int id){
        CostumerDTO response = service.getCostumerById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CostumerDTO>> getAllCostumers(){
        List<CostumerDTO> response = service.getAllCostumers();
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateCostumer(@RequestBody UpdateCostumerCommand costumer){
        service.updateCostumer(costumer);
        return ResponseEntity.ok("Costumer updated successfully");
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteCostumer(@RequestBody DeleteCostummerCommand costumer){
        service.deleteCostumer(costumer);
        return ResponseEntity.ok("Costumer deleted successfully");
    }
}
