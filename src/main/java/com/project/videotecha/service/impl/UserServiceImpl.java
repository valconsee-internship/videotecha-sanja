package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.repository.UserRepository;
import com.project.videotecha.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Not found user with ID " + userId));
    }
}
