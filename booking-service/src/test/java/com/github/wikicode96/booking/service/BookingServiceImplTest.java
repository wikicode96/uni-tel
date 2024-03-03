package com.github.wikicode96.booking.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;
import com.github.wikicode96.booking.entity.BookingEntity;
import com.github.wikicode96.booking.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private BookingRepository repository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBooking() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();
        BookingEntity bookingEntity = new BookingEntity();
        when(modelMapper.map(bookingCommand, BookingEntity.class)).thenReturn(bookingEntity);

        // When
        assertDoesNotThrow(() -> bookingService.createBooking(bookingCommand));
    }

    @Test
    public void testGetBookingById() {
        // Given
        int bookingId = 1;
        BookingEntity bookingEntity = new BookingEntity();
        when(repository.findById(bookingId)).thenReturn(Optional.of(bookingEntity));
        when(modelMapper.map(bookingEntity, BookingDTO.class)).thenReturn(new BookingDTO());

        // When
        BookingDTO bookingDTO = bookingService.getBookingById(bookingId);

        // Then
        assertNotNull(bookingDTO);
    }

    @Test
    public void testGetAllBookings() {
        // Given
        List<BookingEntity> bookingEntities = new ArrayList<>();
        bookingEntities.add(new BookingEntity());
        when(repository.findAll()).thenReturn(bookingEntities);

        // When
        List<BookingDTO> bookingDTOs = bookingService.getAllBookings();

        // Then
        assertNotNull(bookingDTOs);
        assertEquals(1, bookingDTOs.size());
    }

    @Test
    public void testGetAllBookingsByUserId() {
        // Given
        int userId = 1;
        List<BookingEntity> bookingEntities = new ArrayList<>();
        bookingEntities.add(new BookingEntity());
        when(repository.findByUserId(userId)).thenReturn(bookingEntities);

        // When
        List<BookingDTO> bookingDTOs = bookingService.getAllBookingsByUserId(userId);

        // Then
        assertNotNull(bookingDTOs);
        assertEquals(1, bookingDTOs.size());
    }

    @Test
    public void testUpdateBooking_WithValidId() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();
        bookingCommand.setId(1);

        // When & Then
        assertDoesNotThrow(() -> bookingService.updateBooking(bookingCommand));
    }

    @Test
    public void testUpdateBooking_WithInvalidId() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();

        // When & Then
        assertThrows(ResponseStatusException.class, () -> bookingService.updateBooking(bookingCommand));
    }

    @Test
    public void testDeleteBooking() {
        // Given
        BookingCommand bookingCommand = new BookingCommand();
        bookingCommand.setId(1);
        BookingEntity bookingEntity = new BookingEntity();
        when(repository.findById(bookingCommand.getId())).thenReturn(Optional.of(bookingEntity));

        // When & Then
        assertDoesNotThrow(() -> bookingService.deleteBooking(bookingCommand));
    }
}
