package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Booking;
import com.github.wikicode96.repository.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService service;

    // CRUD
    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Booking> newBooking(@RequestBody Booking booking){
        Booking response = service.newBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "booking/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Booking> getBookingById(@PathVariable("id") int id){
        Booking response = service.getBookingById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> response = service.getAllBookings();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        Booking response = service.updateBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Booking> deleteBooking(@RequestBody Booking booking){
        Booking response = service.deleteBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
