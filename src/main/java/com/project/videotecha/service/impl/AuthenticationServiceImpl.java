package com.project.videotecha.service.impl;

import com.project.videotecha.dto.RegistrationDataDto;
import com.project.videotecha.exception.BadCredentialsException;
import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.model.Role;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.RoleRepository;
import com.project.videotecha.service.AuthenticationService;
import com.project.videotecha.service.TokenService;
import com.project.videotecha.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public AuthenticationServiceImpl(UserService userService, TokenService tokenService,
                                     PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User registerUser(RegistrationDataDto registrationData) {
        Role role = roleRepository.findById(registrationData.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException(format("Not found role with ID %s", registrationData.getRoleId())));

        User newUser = UserMapper.mapRegistrationDataDtoToUser(registrationData, role);

        return userService.registerUser(newUser);
    }

    @Override
    public String login(String email, String password) {
        User user = userService.getByEmail(email);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        return tokenService.generateToken(user);
    }

}
