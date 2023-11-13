package com.github.wikicode96.admin.service;

import com.github.wikicode96.admin.model.User;

public interface UserService {

    User[] getAllUsers();
    void deleteUser(User user);
}
