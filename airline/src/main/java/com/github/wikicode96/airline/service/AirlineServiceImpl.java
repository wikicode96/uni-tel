package com.github.wikicode96.airline.service;

import com.github.wikicode96.airline.entity.AirlineEntity;
import com.github.wikicode96.airline.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    private AirlineRepository repository;

    @Override
    public AirlineEntity newAirline(AirlineEntity airline) {

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
    public AirlineEntity getAirlineById(int id) {
        if(id > 0) return repository.findById(id).orElse(null);
        else return null;
    }

    @Override
    public List<AirlineEntity> getAllAirlines() {
        return repository.findAll();
    }

    @Override
    public AirlineEntity updateAirline(AirlineEntity airline) {

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
    public AirlineEntity deleteAirline(AirlineEntity airline) {

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
