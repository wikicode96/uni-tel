package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:50000";

    @Override
    public Booking[] getAllBookings() {
        return restTemplate.getForObject(url + "/bookings", Booking[].class);
    }
}
