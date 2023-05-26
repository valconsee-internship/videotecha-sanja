package com.project.videotecha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OmdbSearchResultDto implements Serializable {

    @JsonProperty("Search")
    private List<OmdbMovieDto> search;

    private String totalResults;

    public OmdbSearchResultDto(List<OmdbMovieDto> search, String totalResults) {
        this.search = search;
        this.totalResults = totalResults;
    }

    public List<OmdbMovieDto> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbMovieDto> search) {
        this.search = search;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getTotalResults() {
        return totalResults;
    }

}
