package com.project.videotecha.service;

import com.project.videotecha.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {
    String generateToken(User user);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

}
