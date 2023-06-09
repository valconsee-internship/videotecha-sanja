package com.project.videotecha.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class WatchlistDTO implements Serializable {

    @NotNull(message = "User is required. ")
    private final Long userId;
    @NotNull(message = "Movie is required. ")
    private final Long movieId;

    public WatchlistDTO(Long userId, Long movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMovieId() {
        return movieId;
    }

}
