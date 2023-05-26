package com.project.videotecha.service.impl;

import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.UserRepository;
import com.project.videotecha.service.UserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import java.util.Collection;
import static java.lang.String.format;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAll() {
        logger.info("Fetching list of all users!");
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User newUser) {
        logger.info("Saving user {} {}.",newUser.getFirstName(),newUser.getLastName());
        return userRepository.save(newUser);
    }

    @Override
    public User getById(Long userId) {
        logger.info("Fetching user with ID = {}", userId);
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found user with ID %s", userId)));
    }
}
