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
        }
        return null;
    }

    @Override
    public Flight getFlightById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    @Override
    public Flight updateFlight(Flight flight) {

        if(flight.getId() > 0) {
            try{
                repository.save(flight);
                return flight;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public Flight deleteFlight(Flight flight) {

        if(flight.getId() > 0) {
            try{
                repository.delete(flight);
                return flight;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
