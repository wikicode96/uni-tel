package com.github.wikicode96.booking.controller;

import com.github.wikicode96.booking.entity.BookingEntity;
import com.github.wikicode96.booking.service.BookingService;
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

    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookingEntity> newBooking(@RequestBody BookingEntity booking){
        BookingEntity response = service.newBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping(value = "booking/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookingEntity> getBookingById(@PathVariable("id") int id){
        BookingEntity response = service.getBookingById(id);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<BookingEntity>> getAllBookings(){
        List<BookingEntity> response = service.getAllBookings();

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "bookings/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<BookingEntity>> getAllBookingsByUserId(@PathVariable("id") int idUser){
        List<BookingEntity> response = service.getAllBookingsByUserId(idUser);

        if (!response.isEmpty()) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookingEntity> updateBooking(@RequestBody BookingEntity booking){
        BookingEntity response = service.updateBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookingEntity> deleteBooking(@RequestBody BookingEntity booking){
        BookingEntity response = service.deleteBooking(booking);

        if (response != null) return ResponseEntity.ok(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
