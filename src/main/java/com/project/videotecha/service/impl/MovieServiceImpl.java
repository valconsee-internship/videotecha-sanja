package com.project.videotecha.service.impl;

import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.exception.MovieHasFutureProjectionsException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.Projection;
import com.project.videotecha.repository.MovieRepository;
import com.project.videotecha.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

@Service
public class MovieServiceImpl implements MovieService {
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        logger.info("Creating new movie, {}!",movie.getName());
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public Movie update(Movie movie) {
        Movie oldMovie = getById(movie.getId());
        logger.info("Updating movie {}, with Id = {}!",oldMovie.getName(), oldMovie.getId());
        if (hasActiveProjections(oldMovie)) {
            throw new MovieHasFutureProjectionsException("Movie has future projections, it cannot be updated!");
        }
        movie.setProjections(oldMovie.getProjections());
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Movie movie = getById(id);
        if (hasActiveProjections(movie)) {
            throw new MovieHasFutureProjectionsException("Movie has future projections, it cannot be deleted!");
        }
        movie.setDeleted(true);
        logger.info("Deleting movie {} (Id = {}).",movie.getName(),movie.getId());
        movieRepository.save(movie);
    }

    private boolean hasActiveProjections(Movie movie) {
        logger.info("Checking movie {}(Id = {}) projection status.",movie.getName(), movie.getId());
        return movie.getProjections()
                .stream()
                .anyMatch(p -> !p.getDeleted() && !hasPassed(p));
    }

    @Override
    public boolean hasPassed(Projection p) {
        LocalDateTime now = LocalDateTime.now();
        logger.info("Checking if projection (Id = {}) has passed.", p.getId());
        return p.getEnd().isBefore(now) || (p.getStart().isBefore(now) && p.getEnd().isAfter(now));
    }

    @Override
    public List<Movie> getAll() {
        logger.info("Fetching list of all movies.");
        return movieRepository.findByDeletedFalse();
    }

    @Override
    @Transactional
    public Movie getById(Long id) {
        logger.info("Fetching movie with Id = {}.", id);
        return movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found movie with ID %s!", id)));
    }
}
