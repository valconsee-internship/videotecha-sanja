package com.project.videotecha.controller;

import com.project.videotecha.controller.api.UserControllerApi;
import com.project.videotecha.dto.UserDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController implements UserControllerApi {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public Collection<UserDto> getAll() {
        return UserMapper.mapToDtos(userService.getAll());
    }
}
