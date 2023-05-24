package com.project.videotecha.service;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.UserWatchlistItem;

import java.util.List;

public interface WatchlistService {

    UserWatchlistItem addToWatchlist(AddToWatchlistDTO addToWatchlistDTO);

    List<Movie> getUsersWatchlist(Long id);

}
