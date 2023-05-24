package com.project.videotecha.controller;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.dto.WatchlistDTO;
import com.project.videotecha.mapper.WatchlistMapper;
import com.project.videotecha.model.UserWatchlist;
import com.project.videotecha.service.WatchlistService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/watchlist")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping
    public WatchlistDTO addToWatchlist(@RequestBody @Valid AddToWatchlistDTO addToWatchlistDTO) {
        return WatchlistMapper.toDto(watchlistService.addToWatchlist(addToWatchlistDTO));
    }

}
