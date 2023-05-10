package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;


    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User registerUser(User newUser) {
        return userService.registerUser(newUser);
    }

}
