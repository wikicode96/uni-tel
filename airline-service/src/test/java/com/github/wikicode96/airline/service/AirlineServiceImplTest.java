package com.github.wikicode96.airline.service;

import com.github.wikicode96.airline.command.AirlineCommand;
import com.github.wikicode96.airline.dto.AirlineDTO;
import com.github.wikicode96.airline.entity.AirlineEntity;
import com.github.wikicode96.airline.repository.AirlineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirlineServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AirlineRepository repository;

    @InjectMocks
    private AirlineServiceImpl airlineService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAirline() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();
        AirlineEntity airlineEntity = new AirlineEntity();
        when(modelMapper.map(airlineCommand, AirlineEntity.class)).thenReturn(airlineEntity);

        // When
        airlineService.createAirline(airlineCommand);

        // Then
        verify(repository, times(1)).save(airlineEntity);
    }

    @Test
    public void testGetAirlineByName() {
        // Given
        String airlineName = "Test Airline";
        AirlineEntity airlineEntity = new AirlineEntity();
        AirlineDTO expectedAirlineDTO = new AirlineDTO();
        when(repository.findByName(airlineName)).thenReturn(airlineEntity);
        when(modelMapper.map(airlineEntity, AirlineDTO.class)).thenReturn(expectedAirlineDTO);

        // When
        AirlineDTO actualAirlineDTO = airlineService.getAirlineByName(airlineName);

        // Then
        assertNotNull(actualAirlineDTO);
        assertSame(expectedAirlineDTO, actualAirlineDTO);
    }

    @Test
    public void testGetAllAirlines() {
        // Given
        List<AirlineEntity> airlineEntities = new ArrayList<>();
        airlineEntities.add(new AirlineEntity());
        airlineEntities.add(new AirlineEntity());
        when(repository.findAll()).thenReturn(airlineEntities);

        // When
        List<AirlineDTO> airlineDTOs = airlineService.getAllAirlines();

        // Then
        assertNotNull(airlineDTOs);
        assertEquals(2, airlineDTOs.size());
    }

    @Test
    public void testUpdateAirline() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();
        airlineCommand.setId(1);
        AirlineEntity airlineEntity = new AirlineEntity();
        when(modelMapper.map(airlineCommand, AirlineEntity.class)).thenReturn(airlineEntity);

        // When
        airlineService.updateAirline(airlineCommand);

        // Then
        verify(repository, times(1)).save(airlineEntity);
    }

    @Test
    public void testDeleteAirlineByName() {
        // Given
        AirlineCommand airlineCommand = new AirlineCommand();
        airlineCommand.setName("Test Airline");
        AirlineEntity airlineEntity = new AirlineEntity();
        when(repository.findByName(airlineCommand.getName())).thenReturn(airlineEntity);

        // When
        airlineService.deleteAirlineByName(airlineCommand);

        // Then
        verify(repository, times(1)).delete(airlineEntity);
    }
}