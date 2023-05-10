package com.project.videotecha.service;

import com.project.videotecha.model.Movie;

public interface MovieService {
    Movie create(Movie mapMovieCreationDtoToMovie);

    Movie update(Movie mapMovieDtoToMovie);

    void delete(Long id);
}
