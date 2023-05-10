package com.project.videotecha.mapper;

import com.project.videotecha.dto.MovieCreationDto;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.model.Movie;
import com.project.videotecha.model.enums.MovieGenre;

import java.util.ArrayList;
import java.util.List;

public final class MovieMapper {

    private MovieMapper() {
    }

    public static Movie mapMovieCreationDtoToMovie(MovieCreationDto movieCreationDto) {
        List<MovieGenre> movieGenres = new ArrayList<>();
        for (String movieGenreName : movieCreationDto.getMovieGenres()) {
            movieGenres.add(MovieGenre.valueOf(movieGenreName));
        }
        return new Movie(movieCreationDto.getName(), movieCreationDto.getDirector(), movieCreationDto.getLength(),
                movieCreationDto.getDescription(), movieGenres);
    }

    public static MovieDto mapToDto(Movie movie) {
        List<String> genreNames = new ArrayList<>();
        for (MovieGenre movieGenre : movie.getMovieGenres()) {
            genreNames.add(movieGenre.name());
        }
        return new MovieDto(movie.getId(), movie.getName(), movie.getDirector(), movie.getLength(),
                movie.getDescription(), genreNames);
    }
}
