package com.project.videotecha.service;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.model.User;

public interface AuthenticationService {
    User registerUser(User newUser);
}