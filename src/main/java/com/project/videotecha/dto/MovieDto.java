package com.project.videotecha.dto;

import com.project.videotecha.model.Movie;

import java.util.List;

public class MovieDto {
    private Long id;
    private String name;
    private String director;
    private Integer length;
    private String description;
    private List<String> movieGenres;

    public MovieDto() {
    }

    public MovieDto(Movie movie, List<String> genres) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.director = movie.getDirector();
        this.length = movie.getLength();
        this.description = movie.getDescription();
        this.movieGenres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<String> movieGenres) {
        this.movieGenres = movieGenres;
    }
}
