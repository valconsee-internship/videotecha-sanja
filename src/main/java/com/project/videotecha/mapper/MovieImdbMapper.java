package com.project.videotecha.mapper;

import com.project.videotecha.dto.MovieDetailsDto;
import com.project.videotecha.model.Movie;

public class MovieImdbMapper {

    public static MovieDetailsDto toDto(Movie movie) {
        return new MovieDetailsDto(movie.getId(), movie.getName(), movie.getDirector(), movie.getLength(),
                movie.getDescription(), movie.getMovieGenres(), movie.getImdbId());
    }

}
