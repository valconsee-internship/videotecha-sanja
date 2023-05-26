package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OmdbSearchResultDto implements Serializable {

    @JsonProperty("Search")
    private List<OmdbMovieDto> search;

    private String totalResults;

}
