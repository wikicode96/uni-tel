package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.Booking;
import com.github.wikicode96.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

    @Override
    public void deleteBooking(Booking booking) {
        if(booking.getId() > 0){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Booking> requestEntity = new HttpEntity<>(booking, headers);
            restTemplate.exchange(url + "/booking", HttpMethod.DELETE, requestEntity, Void.class);
        }
    }
}
