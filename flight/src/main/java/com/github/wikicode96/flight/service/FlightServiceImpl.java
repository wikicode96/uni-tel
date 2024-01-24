package com.github.wikicode96.flight.service;

import com.github.wikicode96.flight.entity.FlightEntity;
import com.github.wikicode96.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository repository;

    @Override
    public FlightEntity newFlight(FlightEntity flight) {

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
    public FlightEntity getFlightById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        return repository.findAll();
    }

    @Override
    public List<FlightEntity> getAllFlightsByAirlineId(int idAirline) {
        return repository.findByAirlineId(idAirline);
    }

    @Override
    public FlightEntity updateFlight(FlightEntity flight) {

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
    public FlightEntity deleteFlight(FlightEntity flight) {

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
