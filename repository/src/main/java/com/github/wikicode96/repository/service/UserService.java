package com.github.wikicode96.repository.service;

import com.github.wikicode96.repository.entity.User;

import java.util.List;

public interface UserService {

    // CRUD
    User newUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUser(User user);
    User deleteUser(User user);
}
