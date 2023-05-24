package com.project.videotecha.service.impl;

import com.project.videotecha.dto.AddToWatchlistDTO;
import com.project.videotecha.exception.BusinessRuleException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.User;
import com.project.videotecha.model.UserWatchlistItem;
import com.project.videotecha.repository.WatchlistRepository;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.UserService;
import com.project.videotecha.service.WatchlistService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserWatchlistItem addToWatchlist(AddToWatchlistDTO addToWatchlistDTO) {
        User user = userService.getById(addToWatchlistDTO.getUserId());
        Movie movie = movieService.getById(addToWatchlistDTO.getMovieId());
        List<Movie> userWatchlist = getUsersWatchlist(user.getId());
        if (userWatchlist.contains(movie)) {
            throw new BusinessRuleException("Already in watchlist!");
        }
        UserWatchlistItem userWatchlistItem = new UserWatchlistItem(user, movie);
        return watchlistRepository.save(userWatchlistItem);
    }

    @Override
    public List<Movie> getUsersWatchlist(Long id) {
        return watchlistRepository.findAllByUserId(id)
                .stream()
                .map(UserWatchlistItem::getMovie)
                .toList();
    }

}
