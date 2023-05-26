package com.project.videotecha.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class UpdateMovieDto implements Serializable {

    @NotNull(message = "Id is required")
    private Long movieId;

    @NotNull(message = "Imdb is required")
    @Length(min = 9, max =  9, message = "Imdb id must be 9 characters long")
    private String imdbId;

    public Long getMovieId() {
        return movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

}
