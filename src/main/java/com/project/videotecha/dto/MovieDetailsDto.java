package com.project.videotecha.dto;

import com.project.videotecha.model.enums.MovieGenre;

import java.io.Serializable;
import java.util.List;

public class MovieDetailsDto implements Serializable {

    private final Long id;
    private final String name;
    private final String director;
    private final int length;
    private final String description;
    private final List<MovieGenre> movieGenres;
    private final String imdbId;

    public MovieDetailsDto(Long id, String name, String director, int length, String description, List<MovieGenre> movieGenres, String imdbId) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.length = length;
        this.description = description;
        this.movieGenres = movieGenres;
        this.imdbId = imdbId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public List<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public String getImdbId() {
        return imdbId;
    }

}
