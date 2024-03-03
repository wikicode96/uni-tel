package com.github.wikicode96.airline.controller;

import com.github.wikicode96.airline.command.AirlineCommand;
import com.github.wikicode96.airline.dto.AirlineDTO;
import com.github.wikicode96.airline.service.AirlineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirlineControllerTest {

    @Mock
    private AirlineService service;

    @InjectMocks
    private AirlineController airlineController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAirline() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();

        // When
        ResponseEntity<String> responseEntity = airlineController.createAirline(airlineCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Airline created successfully", responseEntity.getBody());
        verify(service, times(1)).createAirline(airlineCommand);
    }

    @Test
    public void testGetAirlineByName() {
        // Given
        String airlineName = "Test Airline";
        AirlineDTO airlineDTO = new AirlineDTO();
        when(service.getAirlineByName(airlineName)).thenReturn(airlineDTO);

        // When
        ResponseEntity<AirlineDTO> responseEntity = airlineController.getAirlineByName(airlineName);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(airlineDTO, responseEntity.getBody());
    }

    @Test
    public void testGetAllAirlines() {
        // Given
        List<AirlineDTO> airlineDTOs = new ArrayList<>();
        when(service.getAllAirlines()).thenReturn(airlineDTOs);

        // When
        ResponseEntity<List<AirlineDTO>> responseEntity = airlineController.getAllAirlines();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(airlineDTOs, responseEntity.getBody());
    }

    @Test
    public void testUpdateAirline() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();

        // When
        ResponseEntity<String> responseEntity = airlineController.updateAirline(airlineCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Airline updated successfully", responseEntity.getBody());
        verify(service, times(1)).updateAirline(airlineCommand);
    }

    @Test
    public void testDeleteAirlineByName() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();

        // When
        ResponseEntity<String> responseEntity = airlineController.deleteAirlineByName(airlineCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Airline deleted successfully", responseEntity.getBody());
        verify(service, times(1)).deleteAirlineByName(airlineCommand);
    }
}