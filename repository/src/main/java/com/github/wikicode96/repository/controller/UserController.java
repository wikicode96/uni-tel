package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.User;
import com.github.wikicode96.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    // CRUD
    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> newUser(@RequestBody User user){
        User response = service.newUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User response = service.getUserById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> getAllUsers(){
        List<User> response = service.getAllUsers();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> updateUser(@RequestBody User user){
        User response = service.updateUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> deleteUser(@RequestBody User user){
        User response = service.deleteUser(user);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
