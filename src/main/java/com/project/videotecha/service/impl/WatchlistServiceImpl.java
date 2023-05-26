package com.project.videotecha.service.impl;

import com.project.videotecha.dto.WatchlistDTO;
import com.project.videotecha.exception.BusinessRuleException;
import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.User;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.UserService;
import com.project.videotecha.service.WatchlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {
    private static final Logger logger = LoggerFactory.getLogger(WatchlistServiceImpl.class);

    private final UserService userService;

    private final MovieService movieService;


    public WatchlistServiceImpl(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @Override
    public Movie addToWatchlist(WatchlistDTO watchlistDTO) {
        User user = userService.getById(watchlistDTO.getUserId());
        Movie movie = movieService.getById(watchlistDTO.getMovieId());
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
        logger.info("Fetching watchlist for user {} {} (Id={}).",user.getFirstName(),user.getLastName(),user.getId());
        return user.getWatchLists();
    }

    @Override
    public void deleteFromWatchlist(WatchlistDTO watchlistDTO) {
        User user = userService.getById(watchlistDTO.getUserId());
        Movie movie = movieService.getById(watchlistDTO.getMovieId());
        List<Movie> userWatchlist = getUsersWatchlist(user.getId());
        if (!userWatchlist.contains(movie)) {
            throw new EntityNotFoundException(String.format("Movie with id %d is not in the watchlist", movie.getId()));
        }
        userWatchlist.remove(movie);
        logger.info("Deleting movie {}(Id={}) from {} {} Id={} watchlist.",movie.getName(),movie.getId(),user.getFirstName(),user.getLastName(),user.getId());
        userService.saveUser(user);
    }

}
