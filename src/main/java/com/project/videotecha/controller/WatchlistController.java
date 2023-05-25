package com.project.videotecha.controller;

import com.project.videotecha.dto.WatchlistDTO;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.mapper.MovieMapper;
import com.project.videotecha.service.WatchlistService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public MovieDto addToWatchlist(@RequestBody @Valid WatchlistDTO watchlistDTO) {
        return MovieMapper.mapToDto(watchlistService.addToWatchlist(watchlistDTO));
    }

    @DeleteMapping
    public void deleteFromWatchlist(@RequestBody @Valid WatchlistDTO watchlistDTO) {
        watchlistService.deleteFromWatchlist(watchlistDTO);
    }

}
