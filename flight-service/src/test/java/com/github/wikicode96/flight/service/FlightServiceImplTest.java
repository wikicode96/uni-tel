package com.github.wikicode96.flight.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.AirlineDTO;
import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.entity.AirlineEntity;
import com.github.wikicode96.flight.entity.FlightEntity;
import com.github.wikicode96.flight.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private FlightRepository repository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateFlight_WithValidAirline() {
        // Given
        FlightCommand flightCommand = new FlightCommand();
        flightCommand.setAirline("AA"); // assuming this is a valid airline code
        // Mocking successful response from RestTemplate
        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.setId(1);
        airlineDTO.setName("Test Airline");
        airlineDTO.setImgLogo("logo.jpg");
        when(restTemplate.getForObject("http://localhost:50000/airline/AA", AirlineDTO.class)).thenReturn(airlineDTO);

        // Mocking mapping behavior
        when(modelMapper.map(any(AirlineDTO.class), eq(AirlineEntity.class))).thenReturn(new AirlineEntity());
        when(modelMapper.map(any(FlightCommand.class), eq(FlightEntity.class))).thenReturn(new FlightEntity());

        // When
        flightService.createFlight(flightCommand);

        // Then
        verify(restTemplate, times(1)).getForObject("http://localhost:50000/airline/AA", AirlineDTO.class);
        verify(repository, times(1)).save(any(FlightEntity.class));
    }

    @Test
    public void testCreateFlight_WithInvalidAirline() {
        // Given
        FlightCommand flightCommand = new FlightCommand();
        flightCommand.setAirline("Invalid Airline");
        when(restTemplate.getForObject(anyString(), eq(AirlineDTO.class))).thenThrow(HttpClientErrorException.NotFound.class);

        // When & Then
        assertThrows(ResponseStatusException.class, () -> flightService.createFlight(flightCommand));
    }

    @Test
    public void testGetFlightById() {
        // Given
        int flightId = 1;
        FlightEntity flightEntity = new FlightEntity();
        when(repository.getReferenceById(flightId)).thenReturn(flightEntity);
        when(modelMapper.map(flightEntity, FlightDTO.class)).thenReturn(new FlightDTO());

        // When
        FlightDTO flightDTO = flightService.getFlightById(flightId);

        // Then
        assertNotNull(flightDTO);
    }

    @Test
    public void testGetAllFlights() {
        // Given
        List<FlightEntity> flightEntities = new ArrayList<>();
        flightEntities.add(new FlightEntity());
        when(repository.findAll()).thenReturn(flightEntities);

        // When
        List<FlightDTO> flightDTOs = flightService.getAllFlights();

        // Then
        assertNotNull(flightDTOs);
        assertEquals(1, flightDTOs.size());
    }

    @Test
    public void testGetAllFlightsByAirline() {
        // Given
        String airlineName = "Test Airline";
        List<FlightEntity> flightEntities = new ArrayList<>();
        flightEntities.add(new FlightEntity());
        when(repository.findAllByAirlineName(airlineName)).thenReturn(flightEntities);

        // When
        List<FlightDTO> flightDTOs = flightService.getAllFlightsByAirline(airlineName);

        // Then
        assertNotNull(flightDTOs);
        assertEquals(1, flightDTOs.size());
    }

    @Test
    public void testUpdateFlightById() {
        // Given
        FlightCommand flightCommand = new FlightCommand();
        flightCommand.setId(1);

        // When & Then
        assertDoesNotThrow(() -> flightService.updateFlightById(flightCommand));
    }

    @Test
    public void testDeleteFlightById() {
        // Given
        FlightCommand flightCommand = new FlightCommand();
        flightCommand.setId(1);
        FlightEntity flightEntity = new FlightEntity();
        when(repository.getReferenceById(flightCommand.getId())).thenReturn(flightEntity);

        // When & Then
        assertDoesNotThrow(() -> flightService.deleteFlightById(flightCommand));
    }
}
