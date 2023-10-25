package com.github.wikicode96.admin.service;

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
        return restTemplate.getForObject(url + "/flights", Flight[].class);
    }
}
