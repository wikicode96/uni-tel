package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Flight;
import com.github.wikicode96.repository.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @InjectMocks
    FlightService service = new FlightServiceImpl();

    @Mock
    FlightRepository repository;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        flight = new Flight();
    }

    @Test
    void newFlight() {
        flight.setId(0);

        flight = service.newFlight(flight);

        assertNotNull("The same Flight object is returned whe id = 0." , flight);
    }

    @Test
    void getFlightById() {
        when(repository.findById(any())).thenReturn(Optional.of(new Flight()));

        flight = service.getFlightById(1);

        assertNotNull("Return the Flight found if exists.", flight);
    }

    @Test
    void updateFlight() {
        flight.setId(1);

        flight = service.updateFlight(flight);

        assertNotNull("The same Flight object is returned whe is found in the db." , flight);
    }

    @Test
    void deleteFlight() {
        flight.setId(1);

        flight = service.deleteFlight(flight);

        assertNotNull("The same Flight object is returned whe is found in the db." , flight);
    }
}