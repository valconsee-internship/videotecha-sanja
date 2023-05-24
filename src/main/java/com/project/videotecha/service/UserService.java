package com.project.videotecha.service;

import com.project.videotecha.model.User;

import java.util.Collection;

public interface UserService {
    Collection<User> getAll();

    User saveUser(User newUser);

    User getById(Long userId);
}
