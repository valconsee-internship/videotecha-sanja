package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieImdbDetailsDto {

    @JsonProperty("Title")
    private final String title;

    @JsonProperty("Year")
    private final String year;

    @JsonProperty("Released")
    private final String released;

    @JsonProperty("Genre")
    private final String genre;

    @JsonProperty("Director")
    private final String director;

    @JsonProperty("Writer")
    private final String writer;

    @JsonProperty("Actors")
    private final String actors;

    @JsonProperty("Language")
    private final String language;

    @JsonProperty("Country")
    private final String country;

    @JsonProperty("Awards")
    private final String awards;

    @JsonProperty("Poster")
    private final String poster;

    private final String imdbRating;

    private final String imdbVotes;

    public MovieImdbDetailsDto(String title, String year, String released, String genre, String director, String writer,
                               String actors, String language, String country, String awards, String poster,
                               String imdbRating, String imdbVotes) {
        this.title = title;
        this.year = year;
        this.released = released;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
    }

}
