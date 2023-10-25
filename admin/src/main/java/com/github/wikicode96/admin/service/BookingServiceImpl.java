package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Booking;
import com.github.wikicode96.admin.model.User;
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
        Booking[] bookings = restTemplate.getForObject(url + "/bookings", Booking[].class);
        User[] users = restTemplate.getForObject(url + "/users", User[].class);

        for (Booking b: bookings) {
            for (User u: users) {
                if (b.getIdUser() == u.getId()) b.setUser(u);
            }
        }

        return bookings;
    }
}
