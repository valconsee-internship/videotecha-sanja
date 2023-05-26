package com.project.videotecha.controller;

import com.project.videotecha.controller.api.MovieControllerApi;
import com.project.videotecha.dto.MovieCreationDto;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.dto.MovieImdbDetailsDto;
import com.project.videotecha.dto.MovieImdbIdDto;
import com.project.videotecha.dto.UpdateMovieDto;
import com.project.videotecha.mapper.MovieImdbMapper;
import com.project.videotecha.mapper.MovieMapper;
import com.project.videotecha.service.MovieService;
import com.project.videotecha.service.OmdbService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController implements MovieControllerApi {
    private final MovieService movieService;

    private final OmdbService omdbService;

    public MovieController(MovieService movieService, OmdbService omdbService) {
        this.movieService = movieService;
        this.omdbService = omdbService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@Valid @RequestBody MovieCreationDto movieCreationDto) {
        return MovieMapper.mapToDto(movieService.create(MovieMapper.mapMovieCreationDtoToMovie(movieCreationDto)));
    }

    @PutMapping
    public MovieDto update(@Valid @RequestBody MovieDto movieDto) {
        return MovieMapper.mapToDto(movieService.update(MovieMapper.mapMovieDtoToMovie(movieDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @GetMapping("/{id}")
    public MovieImdbIdDto getById(@PathVariable Long id) {
        return MovieImdbMapper.toDto(movieService.getById(id));
    }

    @GetMapping
    public List<MovieDto> getAll() {
        return MovieMapper.mapToMovieDtos(movieService.getAll());
    }

    @PatchMapping
    public MovieImdbIdDto addImdbId(@RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return MovieImdbMapper.toDto(movieService.updateMovieImdbId(updateMovieDto));
    }

    @GetMapping("{imdbId}/details")
    public MovieImdbDetailsDto movieDetailsFromImdb(@PathVariable String imdbId) {
        return omdbService.getMovieDetailsFromImdb(imdbId);
    }

}
