package com.project.videotecha.controller;

import com.project.videotecha.dto.UserDto;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<UserDto> getAll() {
        return UserMapper.mapToDtos(userService.getAll());
    }
}
