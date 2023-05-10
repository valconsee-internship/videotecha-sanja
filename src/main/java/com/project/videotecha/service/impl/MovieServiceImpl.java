package com.project.videotecha.service.impl;

import com.project.videotecha.model.Movie;
import com.project.videotecha.repository.MovieRepository;
import com.project.videotecha.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Movie update(Movie movie) {
        if (movieRepository.findByIdAndDeletedFalse(movie.getId()).isEmpty()) {
            throw new EntityNotFoundException("Movie with ID " + movie.getId() + " not found");
        }
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Movie movie = movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with ID " + id + " not found"));
        movie.setDeleted(true);
        movieRepository.save(movie);
    }


}