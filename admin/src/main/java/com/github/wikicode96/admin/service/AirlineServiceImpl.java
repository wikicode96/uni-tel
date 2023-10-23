package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:50000";

    @Override
    public Airline[] getAllAirlines() {

        return restTemplate.getForObject(url + "/airlines", Airline[].class);
    }
}
