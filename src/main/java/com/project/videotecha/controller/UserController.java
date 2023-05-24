package com.project.videotecha.controller;

import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.dto.UserDto;
import com.project.videotecha.mapper.MovieMapper;
import com.project.videotecha.mapper.UserMapper;
import com.project.videotecha.service.UserService;
import com.project.videotecha.service.WatchlistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final WatchlistService watchlistService;

    public UserController(UserService userService, WatchlistService watchlistService) {
        this.userService = userService;
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public Collection<UserDto> getAll() {
        return UserMapper.mapToDtos(userService.getAll());
    }

    @GetMapping("{id}/watchlist")
    public List<MovieDto> getUsersWatchlist(@PathVariable Long id) {
        return watchlistService.getUsersWatchlist(id)
                .stream()
                .map(MovieMapper::mapToDto)
                .toList();
    }

}
