package com.github.wikicode96.booking.controller;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;
import com.github.wikicode96.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createBooking(@RequestBody BookingCommand booking){
        service.createBooking(booking);
        return ResponseEntity.ok("Booking created successfully");
    }

    @GetMapping(params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookingDTO> getBookingById(@RequestParam("id") int id){
        BookingDTO response = service.getBookingById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<BookingDTO>> getAllBookings(){
        List<BookingDTO> response = service.getAllBookings();
        return ResponseEntity.ok(response);
    }

    @GetMapping(params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<BookingDTO>> getAllBookingsByUserId(@RequestParam("userId") int userId){
        List<BookingDTO> response = service.getAllBookingsByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateBooking(@RequestBody BookingCommand booking){
        service.updateBooking(booking);
        return ResponseEntity.ok("Booking updated successfully");
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteBooking(@RequestBody BookingCommand booking){
        service.deleteBooking(booking);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
