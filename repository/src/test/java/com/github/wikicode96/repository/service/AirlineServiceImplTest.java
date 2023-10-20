package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Airline;
import com.github.wikicode96.repository.repository.AirlineRepository;
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
class AirlineServiceImplTest {

    @InjectMocks
    AirlineService service = new AirlineServiceImpl();

    @Mock
    AirlineRepository repository;

    private Airline airline;

    @BeforeEach
    public void setUp() {
        airline = new Airline();
    }

    @Test
    void newAirline() {
        airline.setId(0);

        airline = service.newAirline(airline);

        assertNotNull("The same Airline object is returned whe id = 0." ,airline);
    }

    @Test
    void getAirlineById() {
        when(repository.findById(any())).thenReturn(Optional.of(new Airline()));

        airline = service.getAirlineById(1);

        assertNotNull("Return the airline found if exists.", airline);
    }

    @Test
    void updateAirline() {
        airline.setId(1);

        airline = service.updateAirline(airline);

        assertNotNull("The same Airline object is returned whe is found in the db." ,airline);
    }

    @Test
    void deleteAirline() {
        airline.setId(1);

        airline = service.deleteAirline(airline);

        assertNotNull("The same Airline object is returned whe is found in the db." ,airline);
    }
}