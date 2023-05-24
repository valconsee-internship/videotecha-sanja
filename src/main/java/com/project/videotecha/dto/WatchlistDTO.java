package com.project.videotecha.dto;

import java.io.Serializable;

public class WatchlistDTO implements Serializable {

    private final UserDto userDto;

    private final MovieDto movieDto;

    public WatchlistDTO(UserDto userDto, MovieDto movieDto) {
        this.userDto = userDto;
        this.movieDto = movieDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

}
