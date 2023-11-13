package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking newBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getAllBookings();
    List<Booking> getAllBookingsByUserId(int idUser);
    Booking updateBooking(Booking booking);
    Booking deleteBooking(Booking booking);
}
