package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Airline;
import com.github.wikicode96.admin.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:50000";

    @Override
    public Flight[] getAllFlights() {
        Flight[] flights = restTemplate.getForObject(url + "/flights", Flight[].class);
        Airline[] airlines = restTemplate.getForObject(url + "/airlines", Airline[].class);

        for (Flight f: flights) {
            for (Airline a: airlines) {
                if(f.getIdAirline() == a.getId()) f.setAirline(a);
            }
        }
        return flights;
    }
}