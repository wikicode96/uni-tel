package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.Booking;
import com.github.wikicode96.admin.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/booking")
public class BookingController {

    @Autowired
    BookingService service;

    @GetMapping("/all")
    String allBookings(Model model){

        Booking[] bookings = service.getAllBookings();
        model.addAttribute("bookings", bookings);

        return "bookings-table";
    }
}
