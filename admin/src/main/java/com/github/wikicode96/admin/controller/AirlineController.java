package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.Airline;
import com.github.wikicode96.admin.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/airline")
public class AirlineController {

    @Autowired
    AirlineService service;

    @GetMapping("/all")
    String allAirlines(Model model){

        Airline[] airlines = service.getAllAirlines();
        model.addAttribute("airlines", airlines);

        return "airline-table";
    }
}
