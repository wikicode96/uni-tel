package com.github.wikicode96.booking.service;

import com.github.wikicode96.booking.entity.BookingEntity;

import java.util.List;

public interface BookingService {
    BookingEntity newBooking(BookingEntity booking);
    BookingEntity getBookingById(int id);
    List<BookingEntity> getAllBookings();
    List<BookingEntity> getAllBookingsByUserId(int idUser);
    BookingEntity updateBooking(BookingEntity booking);
    BookingEntity deleteBooking(BookingEntity booking);
}
