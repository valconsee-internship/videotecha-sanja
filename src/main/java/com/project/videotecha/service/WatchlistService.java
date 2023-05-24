package com.project.videotecha.service;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.model.UserWatchlist;

public interface WatchlistService {

    UserWatchlist addToWatchlist(AddToWatchlistDTO addToWatchlistDTO);

}
