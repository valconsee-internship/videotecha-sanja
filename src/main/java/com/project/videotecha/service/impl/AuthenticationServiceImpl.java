package com.project.videotecha.service.impl;

import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User registerUser(User newUser) {
        logger.info("Creating user {} {}.",newUser.getFirstName(), newUser.getLastName());
        return userService.saveUser(newUser);
    }
}
