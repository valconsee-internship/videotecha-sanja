package com.project.videotecha.service.impl;

import com.project.videotecha.dto.OmdbSearchResultDto;
import com.project.videotecha.service.OmdbService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbServiceImpl implements OmdbService {

    @Value("${omdbAPI.url}")
    private String url;

    private final RestTemplate restTemplate;

    public OmdbServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public OmdbSearchResultDto searchMoviesFromOmdb(String title) {
        try {
            ResponseEntity<OmdbSearchResultDto> searchResult = restTemplate.getForEntity(url + title, OmdbSearchResultDto.class);
            return searchResult.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong: ", e);
        }
    }
}