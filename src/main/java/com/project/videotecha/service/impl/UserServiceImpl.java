package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.repository.UserRepository;
import com.project.videotecha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }
}
