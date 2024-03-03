package com.github.wikicode96.booking.service;

import com.github.wikicode96.booking.command.BookingCommand;
import com.github.wikicode96.booking.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void createBooking(BookingCommand booking);
    BookingDTO getBookingById(int id);
    List<BookingDTO> getAllBookings();
    List<BookingDTO> getAllBookingsByUserId(int userId);
    void updateBooking(BookingCommand booking);
    void deleteBooking(BookingCommand booking);
}
