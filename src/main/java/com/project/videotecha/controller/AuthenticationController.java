package com.project.videotecha.controller;

import com.project.videotecha.dto.LoginDto;
import com.project.videotecha.controller.api.AuthenticationControllerApi;
import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.dto.UserDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController implements AuthenticationControllerApi {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@Valid @RequestBody RegistrationDataDto registrationData) {
        return UserMapper.mapUserToUserDto(authenticationService.registerUser(UserMapper
                .mapRegistrationDataDtoToUser(registrationData)));
    }

    @PostMapping("login")
    public String login(@Valid @RequestBody LoginDto dto) {
        return authenticationService.login(dto.getEmail(), dto.getPassword());
    }

}
