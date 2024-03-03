package com.github.wikicode96.flight.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.flight.command.FlightCommand;
import com.github.wikicode96.flight.dto.FlightDTO;
import com.github.wikicode96.flight.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class FlightControllerTest {

    @Mock
    private FlightService service;

    @InjectMocks
    private FlightController flightController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateFlight() {
        // Given
        FlightCommand flightCommand = new FlightCommand();

        // When
        ResponseEntity<String> responseEntity = flightController.createFlight(flightCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Flight created successfully", responseEntity.getBody());
        verify(service, times(1)).createFlight(flightCommand);
    }

    @Test
    public void testGetFlightById() {
        // Given
        int flightId = 1;
        FlightDTO flightDTO = new FlightDTO();
        when(service.getFlightById(flightId)).thenReturn(flightDTO);

        // When
        ResponseEntity<FlightDTO> responseEntity = flightController.getFlightById(flightId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(flightDTO, responseEntity.getBody());
    }

    @Test
    public void testGetAllFlights() {
        // Given
        List<FlightDTO> flightDTOs = new ArrayList<>();
        when(service.getAllFlights()).thenReturn(flightDTOs);

        // When
        ResponseEntity<List<FlightDTO>> responseEntity = flightController.getAllFlights();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(flightDTOs, responseEntity.getBody());
    }

    @Test
    public void testGetAllFlightsByAirline() {
        // Given
        String airline = "Test Airline";
        List<FlightDTO> flightDTOs = new ArrayList<>();
        when(service.getAllFlightsByAirline(airline)).thenReturn(flightDTOs);

        // When
        ResponseEntity<List<FlightDTO>> responseEntity = flightController.getAllFlightsByAirline(airline);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(flightDTOs, responseEntity.getBody());
    }

    @Test
    public void testUpdateFlight() {
        // Given
        FlightCommand flightCommand = new FlightCommand();

        // When
        ResponseEntity<String> responseEntity = flightController.updateFlight(flightCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Flight updated successfully", responseEntity.getBody());
        verify(service, times(1)).updateFlightById(flightCommand);
    }

    @Test
    public void testDeleteFlight() {
        // Given
        FlightCommand flightCommand = new FlightCommand();

        // When
        ResponseEntity<String> responseEntity = flightController.deleteFlight(flightCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Flight deleted successfully", responseEntity.getBody());
        verify(service, times(1)).deleteFlightById(flightCommand);
    }
}