package com.github.wikicode96.airline.service;

import com.github.wikicode96.airline.entity.AirlineEntity;

import java.util.List;

public interface AirlineService {

    // CRUD
    AirlineEntity newAirline(AirlineEntity airline);
    AirlineEntity getAirlineById(int id);
    List<AirlineEntity> getAllAirlines();
    AirlineEntity updateAirline(AirlineEntity airline);
    AirlineEntity deleteAirline(AirlineEntity airline);
}
