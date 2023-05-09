package com.project.videotecha.service.impl;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.UserRepository;
import com.project.videotecha.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User newUser) {
        userRepository.save(newUser);
        return userRepository.findByEmail(newUser.getEmail());
    }

}
