package com.project.videotecha.service;

import com.project.videotecha.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    Collection<User> getAll();

    User registerUser(User newUser);

    User getById(Long userId);

    User getByEmail(String email);
}
