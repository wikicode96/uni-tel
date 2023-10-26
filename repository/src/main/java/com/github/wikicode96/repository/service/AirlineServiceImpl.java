package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Airline;
import com.github.wikicode96.repository.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    private AirlineRepository repository;

    @Override
    public Airline newAirline(Airline airline) {

        if(airline.getId() == 0){
            try{
                repository.save(airline);
                return airline;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public Airline getAirlineById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<Airline> getAllAirlines() {
        return repository.findAll();
    }

    @Override
    public Airline updateAirline(Airline airline) {

        if(airline.getId() > 0) {
            try{
                repository.save(airline);
                return airline;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public Airline deleteAirline(Airline airline) {

        if(airline.getId() > 0) {
            try{
                repository.delete(airline);
                return airline;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
