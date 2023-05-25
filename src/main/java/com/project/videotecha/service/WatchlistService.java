package com.project.videotecha.service;

import com.project.videotecha.dto.WatchlistDTO;
import com.project.videotecha.model.Movie;

import java.util.List;

public interface WatchlistService {

    Movie addToWatchlist(WatchlistDTO watchlistDTO);

    List<Movie> getUsersWatchlist(Long id);

    void deleteFromWatchlist(WatchlistDTO watchlistDTO);

}
