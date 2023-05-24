package com.project.videotecha.service.impl;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.User;
import com.project.videotecha.model.UserWatchlist;
import com.project.videotecha.repository.WatchlistRepository;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.UserService;
import com.project.videotecha.service.WatchlistService;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl implements WatchlistService {


    private final WatchlistRepository watchlistRepository;

    private final UserService userService;

    private final MovieService movieService;


    public WatchlistServiceImpl(WatchlistRepository watchlistRepository, UserService userService, MovieService movieService) {
        this.watchlistRepository = watchlistRepository;
        this.userService = userService;
        this.movieService = movieService;
    }

    @Override
    public UserWatchlist addToWatchlist(AddToWatchlistDTO addToWatchlistDTO) {
        User user = userService.getById(addToWatchlistDTO.getUserId());
        Movie movie = movieService.getById(addToWatchlistDTO.getMovieId());
        UserWatchlist userWatchlist = new UserWatchlist(user, movie);
        return watchlistRepository.save(userWatchlist);
    }
}
