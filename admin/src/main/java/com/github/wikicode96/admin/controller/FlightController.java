package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.Flight;
import com.github.wikicode96.admin.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/flight")
public class FlightController {

    @Autowired
    FlightService service;

    @GetMapping("/all")
    String allFlights(Model model){

        Flight[] flights = service.getAllFlights();
        model.addAttribute("flights", flights);

        return "flights-table";
    }
}
