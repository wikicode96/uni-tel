package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Airline;
import com.github.wikicode96.admin.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:50000";

    @Override
    public Airline[] getAllAirlines() {
        Airline[] airlines = restTemplate.getForObject(url + "/airlines", Airline[].class);
        Flight[] flights = restTemplate.getForObject(url + "/flights", Flight[].class);

        for (Flight f: flights) {
            for (Airline a: airlines) {
                if(f.getIdAirline() == a.getId()) a.getFlights().add(f);
            }
        }

        return airlines;
    }

    @Override
    public void deleteAirline(Airline airline) {

        if(airline.getId() > 0){
            HttpHeaders airlineHeaders = new HttpHeaders();
            airlineHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Airline> requestEntityToAirline = new HttpEntity<>(airline, airlineHeaders);
            restTemplate.exchange(url + "/airline", HttpMethod.DELETE, requestEntityToAirline, Void.class);

            Flight[] flights = restTemplate.getForObject(url + "/flights/airline/" + airline.getId(), Flight[].class);

            for (Flight f: flights) {
                HttpHeaders flightHeaders = new HttpHeaders();
                flightHeaders.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Flight> requestEntityToFlight = new HttpEntity<>(f, flightHeaders);
                restTemplate.exchange(url + "/flight", HttpMethod.DELETE, requestEntityToFlight, Void.class);
            }
        }
    }
}
