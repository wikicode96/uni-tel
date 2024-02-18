package com.github.wikicode96.flight.service;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.AirlineDTO;
import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.entity.AirlineEntity;
import com.github.wikicode96.flight.entity.FlightEntity;
import com.github.wikicode96.flight.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FlightRepository repository;

    private final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final String urlAirline = "http://localhost:50000/airline/";

    @Override
    public void createFlight(FlightCommand flight) {
        try {
            AirlineDTO airlineResponse = restTemplate.getForObject(urlAirline + flight.getAirline(), AirlineDTO.class);

            AirlineEntity airlineEntity = modelMapper.map(airlineResponse, AirlineEntity.class);
            FlightEntity flightEntity = modelMapper.map(flight, FlightEntity.class);

            flightEntity.setAirline(airlineEntity);
            repository.save(flightEntity);

        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airline not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something was wrong");
        }
    }

    @Override
    public FlightDTO getFlightById(int id) {
        FlightEntity entity = repository.getReferenceById(id);
        return modelMapper.map(entity, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<FlightEntity> entities = repository.findAll();
        List<FlightDTO> dtos = new ArrayList<>();

        for (FlightEntity entity: entities){
            dtos.add(modelMapper.map(entity, FlightDTO.class));
        }
        return dtos;
    }

    @Override
    public List<FlightDTO> getAllFlightsByAirline(String airline) {

        List<FlightEntity> entities = repository.findAllByAirlineName(airline);
        List<FlightDTO> dtos = new ArrayList<>();

        for (FlightEntity entity: entities){
            dtos.add(modelMapper.map(entity, FlightDTO.class));
        }
        return dtos;
    }

    @Override
    public void updateFlightById(FlightCommand flight) {

        if (flight.getId() > 0) {
            try {
                FlightEntity entity = repository.getReferenceById(flight.getId());
                entity.setDepart(flight.getDepart());
                entity.setDestination(flight.getDestination());
                entity.setOrigin(flight.getOrigin());
                repository.save(entity);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Flight ID is invalid");
        }
    }

    @Override
    public void deleteFlightById(FlightCommand flight) {

        FlightEntity entity = repository.getReferenceById(flight.getId());

        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found with id: " + flight.getId());
        }
    }
}
