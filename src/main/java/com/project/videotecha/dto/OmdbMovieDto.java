package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OmdbMovieDto implements Serializable {

    @JsonProperty("Title")
    private final String title;

    @JsonProperty("Year")
    private final String year;

    private final String imdbID;

    @JsonProperty("Type")
    private final String type;

    @JsonProperty("Poster")
    private final String poster;

    public OmdbMovieDto(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

}
