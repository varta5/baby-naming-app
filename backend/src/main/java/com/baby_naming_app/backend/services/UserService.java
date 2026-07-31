package com.baby_naming_app.backend.services;

import java.util.List;

import com.baby_naming_app.backend.models.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

}
