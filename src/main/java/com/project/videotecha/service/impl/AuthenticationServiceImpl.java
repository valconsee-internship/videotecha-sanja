package com.project.videotecha.service.impl;

import com.project.videotecha.exception.BadCredentialsException;
import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.TokenService;
import com.project.videotecha.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationServiceImpl(UserService userService, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User newUser) {
        return userService.saveUser(newUser);
    }

    @Override
    public String login(String email, String password) {
        User user = userService.getByEmail(email);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        return tokenService.generateToken(user);
    }

}
