package com.project.videotecha.controller;

import com.project.videotecha.dto.OmdbSearchResultDto;
import com.project.videotecha.service.OmdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("omdb")
public class OmdbController {

    private final OmdbService omdbService;

    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("{title}")
    public OmdbSearchResultDto getMoviesFromOmdb(@PathVariable String title) {
        return omdbService.searchMoviesFromOmdb(title);
    }

}
