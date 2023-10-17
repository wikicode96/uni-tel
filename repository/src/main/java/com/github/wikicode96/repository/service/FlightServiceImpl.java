package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Flight;
import com.github.wikicode96.repository.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository repository;

    @Override
    public Flight newFlight(Flight flight) {

        if(flight.getId() == 0){
            try{
                repository.save(flight);
                return flight;
            }catch (Exception e){
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Flight getFlightById(int id) {

        try{
            Flight flight = repository.findById(id).orElse(null);

            if (flight != null) return flight;
            else return null;

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    @Override
    public Flight updateFlight(Flight flight) {

        if(flight.getId() > 0) {
            repository.save(flight);
            return flight;
        }else{
            return null;
        }
    }

    @Override
    public Flight deleteFlight(Flight flight) {

        if(flight.getId() > 0) {
            repository.delete(flight);
            return flight;
        }else{
            return null;
        }
    }
}
