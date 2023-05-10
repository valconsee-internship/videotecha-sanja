package com.project.videotecha.service.impl;

import com.project.videotecha.model.Movie;
import com.project.videotecha.repository.MovieRepository;
import com.project.videotecha.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }


}
