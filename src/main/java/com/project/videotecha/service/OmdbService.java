package com.project.videotecha.service;

import com.project.videotecha.dto.MovieDetailsFromOmdbApiDto;
import com.project.videotecha.dto.OmdbSearchResultDto;

public interface OmdbService {

    OmdbSearchResultDto searchMoviesFromOmdb(String title);

    MovieDetailsFromOmdbApiDto getMovieDetailsFromOmdb(String imdbId);

}
