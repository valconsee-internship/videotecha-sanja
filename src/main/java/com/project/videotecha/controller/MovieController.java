package com.project.videotecha.controller;

import com.project.videotecha.controller.api.MovieControllerApi;
import com.project.videotecha.dto.MovieCreationDto;
import com.project.videotecha.dto.MovieDto;
import com.project.videotecha.mapper.MovieMapper;
import com.project.videotecha.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto create(@Valid @RequestBody MovieCreationDto movieCreationDto) {
        return MovieMapper.mapToDto(movieService.create(MovieMapper.mapMovieCreationDtoToMovie(movieCreationDto)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping
    public MovieDto update(@Valid @RequestBody MovieDto movieDto) {
        return MovieMapper.mapToDto(movieService.update(MovieMapper.mapMovieDtoToMovie(movieDto)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @PreAuthorize("hasAuthority(['ROLE_ADMIN', 'ROLE_REGISTERED'])")
    @GetMapping("/{id}")
    public MovieDto getById(@PathVariable Long id) {
        return MovieMapper.mapToDto(movieService.getById(id));
    }

    @Secured({"ROLE_ADMIN", "ROLE_REGISTERED"})
    @GetMapping
    public List<MovieDto> getAll() {
        return MovieMapper.mapToMovieDtos(movieService.getAll());
    }
}
