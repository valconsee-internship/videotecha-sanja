package com.project.videotecha.dto;

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

    public MovieDto(Long id, String name, String director, Integer length, String description, List<String> movieGenres) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.length = length;
        this.description = description;
        this.movieGenres = movieGenres;
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
