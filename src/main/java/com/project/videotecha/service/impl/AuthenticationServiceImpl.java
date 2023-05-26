package com.project.videotecha.service.impl;

import com.project.videotecha.exception.BadCredentialsException;
import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.TokenService;
import com.project.videotecha.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
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
        logger.info("Creating user {} {}.",newUser.getFirstName(), newUser.getLastName());
        return userService.saveUser(newUser);
    }

    @Override
    public String login(String email, String password) {
        User user = userService.getByEmail(email);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            logger.error("Logging credentials are incorrect.");
            throw new BadCredentialsException("Password is incorrect");
        }
        logger.info("User {} {} Id={} is logging in.",user.getFirstName(),user.getLastName(),user.getId());
        return tokenService.generateToken(user);
    }

}
