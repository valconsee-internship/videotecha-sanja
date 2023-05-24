package com.project.videotecha.service.impl;

import com.project.videotecha.exception.BadCredentialsException;
import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.TokenService;
import com.project.videotecha.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    private final TokenService tokenService;


    public AuthenticationServiceImpl(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    public User registerUser(User newUser) {
        return userService.registerUser(newUser);
    }

    @Override
    public String login(String email, String password) {
        User user = userService.getByEmail(email);
        if (password.equals(user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }

        return tokenService.generateToken(user);
    }

}
