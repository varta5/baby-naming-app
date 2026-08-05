package com.baby_naming_app.backend.services;

import java.util.List;
import java.util.UUID;

import com.baby_naming_app.backend.models.User;

public interface UserService {

    List<User> findAll();

    User findById(UUID id) throws Exception;

    User save(User user);

}
