package com.project.videotecha.controller;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.model.User;
import com.project.videotecha.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
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
