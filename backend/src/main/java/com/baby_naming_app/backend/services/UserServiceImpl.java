package com.baby_naming_app.backend.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baby_naming_app.backend.models.User;
import com.baby_naming_app.backend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(UUID id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

}
