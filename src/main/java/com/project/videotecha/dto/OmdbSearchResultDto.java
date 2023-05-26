package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OmdbSearchResultDto implements Serializable {

    @JsonProperty("Search")
    private final List<OmdbMovieDto> search;

    private final String totalResults;

    public OmdbSearchResultDto(List<OmdbMovieDto> search, String totalResults) {
        this.search = search;
        this.totalResults = totalResults;
    }

    public List<OmdbMovieDto> getSearch() {
        return search;
    }

    public String getTotalResults() {
        return totalResults;
    }

}
