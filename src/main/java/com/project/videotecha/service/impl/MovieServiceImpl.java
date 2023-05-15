package com.project.videotecha.service.impl;

import com.project.videotecha.model.Movie;
import com.project.videotecha.model.Projection;
import com.project.videotecha.repository.MovieRepository;
import com.project.videotecha.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private static final String MOVIE_NOT_FOUND_MESSAGE = "Not found movie with ID ";

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
            throw new EntityNotFoundException(MOVIE_NOT_FOUND_MESSAGE + movie.getId());
        }
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Movie movie = movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND_MESSAGE + id));
        List<Projection> projections = movie.getProjections()
                .stream()
                .filter(p -> !p.getDeleted() && !hasPassed(p))
                .toList();
        if (!projections.isEmpty()) {
            throw new RuntimeException("Movie has future projections, it cannot be deleted");
        }
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    private boolean hasPassed(Projection p) {
        return p.getEnd().isBefore(LocalDateTime.now());
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findByDeletedFalse();
    }

    @Override
    @Transactional
    public Movie getById(Long id) {
        return movieRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(MOVIE_NOT_FOUND_MESSAGE + id));
    }
}
