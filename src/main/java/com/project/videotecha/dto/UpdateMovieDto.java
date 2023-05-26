package com.project.videotecha.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class UpdateMovieDto implements Serializable {

    @NotNull(message = "Id is required")
    private final Long movieId;

    @NotNull(message = "Imdb is required")
    @Length(min = 9, max =  9, message = "Imdb id must be 9 characters long")
    private final String imdbId;

    public UpdateMovieDto(Long movieId, String imdbId) {
        this.movieId = movieId;
        this.imdbId = imdbId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

}
