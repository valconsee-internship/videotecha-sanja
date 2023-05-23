package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.model.enums.UserType;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userService.registerUser(newUser);
    }

}
