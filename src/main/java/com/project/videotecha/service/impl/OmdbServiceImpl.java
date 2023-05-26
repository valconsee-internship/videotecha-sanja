package com.project.videotecha.service.impl;

import com.project.videotecha.dto.MovieDetailsFromOmdbApiDto;
import com.project.videotecha.dto.OmdbSearchResultDto;
import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.service.OmdbService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbServiceImpl implements OmdbService {

    @Value("${omdbAPI.search-by-title}")
    private String urlTitle;

    @Value("${omdbAPI.search-by-imdbID}")
    private String urlImdbID;

    private final RestTemplate restTemplate;

    public OmdbServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public OmdbSearchResultDto searchMoviesFromOmdb(String title) {
        try {
            ResponseEntity<OmdbSearchResultDto> searchResult = restTemplate.getForEntity(urlTitle + title, OmdbSearchResultDto.class);
            return searchResult.getBody();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error getting movies from OMDB API");
        }
    }

    @Override
    public MovieDetailsFromOmdbApiDto getMovieDetailsFromOmdb(String imdbId) {
        try {
            ResponseEntity<MovieDetailsFromOmdbApiDto> searchResult = restTemplate.getForEntity(urlImdbID + imdbId, MovieDetailsFromOmdbApiDto.class);
            return searchResult.getBody();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error getting movie details from OMDB API");
        }
    }

}
