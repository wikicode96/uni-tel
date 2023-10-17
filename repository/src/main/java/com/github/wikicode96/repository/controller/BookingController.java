package com.github.wikicode96.repository.controller;

import com.github.wikicode96.repository.entity.Booking;
import com.github.wikicode96.repository.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService service;

    // CRUD
    @PostMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Booking newBooking(Booking booking){
        return service.newBooking(booking);
    }

    @GetMapping(value = "booking/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Booking getBookingById(@PathVariable("id") int id){
        return service.getBookingById(id);
    }

    @GetMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Booking> getAllBookings(){
        return service.getAllBookings();
    }

    @PutMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Booking updateBooking(Booking booking){
        return service.updateBooking(booking);
    }

    @DeleteMapping(value = "booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Booking deleteBooking(Booking booking){
        return service.deleteBooking(booking);
    }
}
