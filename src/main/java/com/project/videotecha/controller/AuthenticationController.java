package com.project.videotecha.controller;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("registration")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody RegistrationDataDto registrationData) {
        return authenticationService.registerUser(UserMapper.mapRegistrationDataDtoToUser(registrationData));
    }

}
