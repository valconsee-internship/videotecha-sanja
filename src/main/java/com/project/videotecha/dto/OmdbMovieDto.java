package com.project.videotecha.dto;

import java.io.Serializable;

public class OmdbMovieDto implements Serializable {

    private final String title;

    private final String year;

    private final String imdbID;

    private final String type;

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
