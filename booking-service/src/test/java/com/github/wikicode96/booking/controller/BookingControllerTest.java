package com.github.wikicode96.booking.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;
import com.github.wikicode96.booking.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class BookingControllerTest {

    @Mock
    private BookingService service;

    @InjectMocks
    private BookingController bookingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBooking() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();

        // When
        ResponseEntity<String> responseEntity = bookingController.createBooking(bookingCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Booking created successfully", responseEntity.getBody());
        verify(service, times(1)).createBooking(bookingCommand);
    }

    @Test
    public void testGetBookingById() {
        // Given
        int bookingId = 1;
        BookingDTO bookingDTO = new BookingDTO();
        when(service.getBookingById(bookingId)).thenReturn(bookingDTO);

        // When
        ResponseEntity<BookingDTO> responseEntity = bookingController.getBookingById(bookingId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(bookingDTO, responseEntity.getBody());
    }

    @Test
    public void testGetAllBookings() {
        // Given
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        when(service.getAllBookings()).thenReturn(bookingDTOs);

        // When
        ResponseEntity<List<BookingDTO>> responseEntity = bookingController.getAllBookings();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(bookingDTOs, responseEntity.getBody());
    }

    @Test
    public void testGetAllBookingsByUserId() {
        // Given
        int userId = 1;
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        when(service.getAllBookingsByUserId(userId)).thenReturn(bookingDTOs);

        // When
        ResponseEntity<List<BookingDTO>> responseEntity = bookingController.getAllBookingsByUserId(userId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(bookingDTOs, responseEntity.getBody());
    }

    @Test
    public void testUpdateBooking() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();

        // When
        ResponseEntity<String> responseEntity = bookingController.updateBooking(bookingCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Booking updated successfully", responseEntity.getBody());
        verify(service, times(1)).updateBooking(bookingCommand);
    }

    @Test
    public void testDeleteBooking() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();

        // When
        ResponseEntity<String> responseEntity = bookingController.deleteBooking(bookingCommand);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Booking deleted successfully", responseEntity.getBody());
        verify(service, times(1)).deleteBooking(bookingCommand);
    }
}
