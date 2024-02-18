package com.github.wikicode96.airline.service;

import com.github.wikicode96.airline.command.AirlineCommand;
import com.github.wikicode96.airline.dto.AirlineDTO;
import com.github.wikicode96.airline.entity.AirlineEntity;
import com.github.wikicode96.airline.repository.AirlineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AirlineRepository repository;

    @Override
    public void createAirline(AirlineCommand airline) {
        AirlineEntity entity = modelMapper.map(airline, AirlineEntity.class);
        repository.save(entity);
    }

    @Override
    public AirlineDTO getAirlineByName(String name) {
        AirlineEntity entity = repository.findByName(name);
        return modelMapper.map(entity, AirlineDTO.class);
    }

    @Override
    public List<AirlineDTO> getAllAirlines() {
        List<AirlineEntity> entities = repository.findAll();
        List<AirlineDTO> dtos = new ArrayList<>();

        for(AirlineEntity entity: entities) {
            dtos.add(modelMapper.map(entity, AirlineDTO.class));
        }
        return dtos;
    }

    @Override
    public void updateAirline(AirlineCommand airline) {

        if (airline.getId() > 0) {
            AirlineEntity entity = modelMapper.map(airline, AirlineEntity.class);
            repository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Airline ID is invalid");
        }
    }

    @Override
    public void deleteAirlineByName(AirlineCommand airline) {
        AirlineEntity entity = repository.findByName(airline.getName());

        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airline not found with name: " + airline.getName());
        }
    }
}
