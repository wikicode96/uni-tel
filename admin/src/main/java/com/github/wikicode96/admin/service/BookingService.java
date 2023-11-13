package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Booking;

public interface BookingService {

    Booking[] getAllBookings();
    void deleteBooking(Booking booking);
}
