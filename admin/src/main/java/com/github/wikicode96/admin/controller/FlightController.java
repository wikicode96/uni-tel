package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.Flight;
import com.github.wikicode96.admin.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/flight")
public class FlightController {

    @Autowired
    FlightService service;

    @GetMapping("/all")
    String allFlights(Model model){

        Flight[] flights = service.getAllFlights();
        model.addAttribute("flights", flights);
        model.addAttribute("booking", new Flight());

        return "flights-table";
    }

    @PostMapping(value = "/delete")
    RedirectView deleteFlight(@RequestParam("idFlight") int id){

        Flight flight = new Flight();
        flight.setId(id);

        service.deleteFlight(flight);

        return new RedirectView("/admin/flight/all");
    }
}
