package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
}
