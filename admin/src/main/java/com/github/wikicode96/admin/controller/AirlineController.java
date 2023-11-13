package com.github.wikicode96.admin.controller;

import com.github.wikicode96.admin.model.Airline;
import com.github.wikicode96.admin.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/airline")
public class AirlineController {

    @Autowired
    AirlineService service;

    @GetMapping("/all")
    String allAirlines(Model model){

        Airline[] airlines = service.getAllAirlines();
        model.addAttribute("airlines", airlines);
        model.addAttribute("airline", new Airline());

        return "airlines-table";
    }

    @PostMapping(value = "/delete")
    RedirectView deleteAirline(@RequestParam("idAirline") int id){

        Airline airline = new Airline();
        airline.setId(id);

        service.deleteAirline(airline);

        return new RedirectView("/admin/airline/all");
    }
}
