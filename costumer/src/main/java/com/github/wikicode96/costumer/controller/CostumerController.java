package com.github.wikicode96.costumer.controller;

import com.github.wikicode96.costumer.entity.CostumerEntity;
import com.github.wikicode96.costumer.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CostumerController {

    @Autowired
    private CostumerService service;

    // CRUD
    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CostumerEntity> newUser(@RequestBody CostumerEntity user){
        CostumerEntity response = service.newUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CostumerEntity> getUserById(@PathVariable("id") int id){
        CostumerEntity response = service.getUserById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CostumerEntity>> getAllUsers(){
        List<CostumerEntity> response = service.getAllUsers();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CostumerEntity> updateUser(@RequestBody CostumerEntity user){
        CostumerEntity response = service.updateUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CostumerEntity> deleteUser(@RequestBody CostumerEntity user){
        CostumerEntity response = service.deleteUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
