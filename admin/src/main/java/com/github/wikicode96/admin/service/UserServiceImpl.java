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
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:50000";

    @Override
    public User[] getAllUsers() {
        return restTemplate.getForObject(url + "/users", User[].class);
    }

    @Override
    public void deleteUser(User user) {
        if(user.getId() > 0){
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<User> requestEntityToUser = new HttpEntity<>(user, userHeaders);
            restTemplate.exchange(url + "/user", HttpMethod.DELETE, requestEntityToUser, Void.class);

            Booking[] bookings = restTemplate.getForObject(url + "/bookings/user/" + user.getId(), Booking[].class);
            for (Booking b: bookings) {
                HttpHeaders bookingHeaders = new HttpHeaders();
                bookingHeaders.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Booking> requestEntityToBooking = new HttpEntity<>(b, bookingHeaders);
                restTemplate.exchange(url + "/booking", HttpMethod.DELETE, requestEntityToBooking, Void.class);
            }
        }
    }
}
