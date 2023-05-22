package com.project.videotecha.service.impl;

import com.project.videotecha.exception.MovieHasFutureProjectionsException;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.Projection;
import com.project.videotecha.repository.MovieRepository;
import com.project.videotecha.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

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
        Movie oldMovie = getById(movie.getId());
        if (hasActiveProjections(oldMovie)) {
            throw new MovieHasFutureProjectionsException("Movie has future projections, it cannot be updated");
        }
        movie.setProjections(oldMovie.getProjections());
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Movie movie = getById(id);
        if (hasActiveProjections(movie)) {
            throw new MovieHasFutureProjectionsException("Movie has future projections, it cannot be deleted");
        }
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    private boolean hasActiveProjections(Movie movie) {
        return movie.getProjections()
                .stream()
                .anyMatch(p -> !p.getDeleted() && !hasPassed(p));
    }

    @Override
    public boolean hasPassed(Projection p) {
        LocalDateTime now = LocalDateTime.now();
        return p.getEnd().isBefore(now) || (p.getStart().isBefore(now) && p.getEnd().isAfter(now));
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findByDeletedFalse();
    }

    @Override
    @Transactional
    public Movie getById(Long id) {
        return movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found movie with ID %s", id)));
    }
}
