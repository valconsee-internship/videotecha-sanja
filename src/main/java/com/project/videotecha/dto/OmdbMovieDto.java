package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OmdbMovieDto implements Serializable {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    private String imdbID;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;

}
