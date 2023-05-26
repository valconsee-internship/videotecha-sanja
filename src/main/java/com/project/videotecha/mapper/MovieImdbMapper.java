package com.project.videotecha.mapper;

import com.project.videotecha.dto.MovieImdbIdDto;
import com.project.videotecha.model.Movie;

public class MovieImdbMapper {

    public static MovieImdbIdDto toDto(Movie movie) {
        return new MovieImdbIdDto(movie.getId(), movie.getName(), movie.getDirector(), movie.getLength(),
                movie.getDescription(), movie.getMovieGenres(), movie.getImdbId());
    }

}
