package com.project.videotecha.service.impl;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.exception.BusinessRuleException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.User;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.UserService;
import com.project.videotecha.service.WatchlistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final UserService userService;

    private final MovieService movieService;


    public WatchlistServiceImpl(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @Override
    public Movie addToWatchlist(AddToWatchlistDTO addToWatchlistDTO) {
        User user = userService.getById(addToWatchlistDTO.getUserId());
        Movie movie = movieService.getById(addToWatchlistDTO.getMovieId());
        List<Movie> userWatchlist = getUsersWatchlist(user.getId());
        if (userWatchlist.contains(movie)) {
            throw new BusinessRuleException("Already in watchlist!");
        }
        userWatchlist.add(movie);
        userService.saveUser(user);
        return movie;
    }

    @Override
    public List<Movie> getUsersWatchlist(Long id) {
        User user = userService.getById(id);
        return user.getWatchLists();
    }

}
