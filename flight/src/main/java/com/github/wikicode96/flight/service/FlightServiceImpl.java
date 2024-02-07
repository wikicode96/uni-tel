package com.github.wikicode96.flight.service;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.AirlineDTO;
import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.entity.AirlineEntity;
import com.github.wikicode96.flight.entity.FlightEntity;
import com.github.wikicode96.flight.repository.FlightRepository;
import org.modelmapper.ModelMapper;
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
    private ModelMapper mapper;

    @Autowired
    private FlightRepository repository;

    private final String urlAirline = "http://localhost:50000/airline/";

    @Override
    public void createFlight(FlightCommand flight) {
        try {
            AirlineDTO airlineResponse = restTemplate.getForObject(urlAirline + flight.getAirline(), AirlineDTO.class);

            AirlineEntity airlineEntity = mapper.map(airlineResponse, AirlineEntity.class);
            FlightEntity flightEntity = mapper.map(flight, FlightEntity.class);

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
        return mapper.map(entity, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<FlightEntity> entities = repository.findAll();
        List<FlightDTO> dtos = new ArrayList<>();

        for (FlightEntity entity: entities){
            dtos.add(mapper.map(entity, FlightDTO.class));
        }
        return dtos;
    }

    @Override
    public List<FlightDTO> getAllFlightsByAirline(String airline) {
        // TODO: Programar
        return null;
    }

    @Override
    public void updateFlightById(FlightCommand flight) {

        if (flight.getId() > 0) {
            FlightEntity entity = mapper.map(flight, FlightEntity.class);
            repository.save(entity);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Flight ID is invalid");
        }
        // TODO: Traer Airline primero
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
