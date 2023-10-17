package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.User;
import com.github.wikicode96.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    // CRUD
    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User newUser(@RequestBody User user){
        return service.newUser(user);
    }

    @GetMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@PathVariable("id") int id){
        return service.getUserById(id);
    }

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PutMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User deleteUser(@RequestBody User user){
        return service.deleteUser(user);
    }
}
