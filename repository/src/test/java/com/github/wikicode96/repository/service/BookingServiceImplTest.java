package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Booking;
import com.github.wikicode96.repository.repository.BookingRepository;
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
class BookingServiceImplTest {

    @InjectMocks
    BookingService service = new BookingServiceImpl();

    @Mock
    BookingRepository repository;

    private Booking booking;

    @BeforeEach
    public void setUp() {
        booking = new Booking();
    }

    @Test
    void newBooking() {
        booking.setId(0);

        booking = service.newBooking(booking);

        assertNotNull("The same Booking object is returned whe id = 0." , booking);
    }

    @Test
    void getBookingById() {
        when(repository.findById(any())).thenReturn(Optional.of(new Booking()));

        booking = service.getBookingById(1);

        assertNotNull("Return the Booking found if exists.", booking);
    }

    @Test
    void updateBooking() {
        booking.setId(1);

        booking = service.updateBooking(booking);

        assertNotNull("The same Booking object is returned whe is found in the db." , booking);
    }

    @Test
    void deleteBooking() {
        booking.setId(1);

        booking = service.deleteBooking(booking);

        assertNotNull("The same Booking object is returned whe is found in the db." , booking);
    }
}