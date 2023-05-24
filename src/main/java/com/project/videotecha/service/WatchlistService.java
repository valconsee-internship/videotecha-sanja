package com.project.videotecha.service;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.model.Movie;

import java.util.List;

public interface WatchlistService {

    Movie addToWatchlist(AddToWatchlistDTO addToWatchlistDTO);

    List<Movie> getUsersWatchlist(Long id);

}
