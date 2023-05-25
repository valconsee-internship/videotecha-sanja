package com.project.videotecha.service;

import com.project.videotecha.model.User;

public interface TokenService {
    String generateToken(User user);
}
