package com.project.videotecha.controller;

import com.project.videotecha.dto.MovieCreationDto;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.mapper.MovieMapper;
import com.project.videotecha.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@RequestBody MovieCreationDto movieCreationDto) {
        return MovieMapper.mapToDto(movieService.create(MovieMapper.mapMovieCreationDtoToMovie(movieCreationDto)));
    }

    @PutMapping
    public MovieDto update(@RequestBody MovieDto movieDto) {
        return MovieMapper.mapToDto(movieService.update(MovieMapper.mapMovieDtoToMovie(movieDto)));
    }
}
