package com.project.videotecha.service;

import com.project.videotecha.model.Movie;

import java.util.List;

public interface MovieService {
    Movie create(Movie mapMovieCreationDtoToMovie);

    Movie update(Movie mapMovieDtoToMovie);

    void delete(Long id);

    List<Movie> getAll();

    Movie getById(Long id);
}
