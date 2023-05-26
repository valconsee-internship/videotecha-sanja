package com.project.videotecha.service;

import com.project.videotecha.dto.MovieImdbDetailsDto;
import com.project.videotecha.dto.OmdbSearchResultDto;

public interface OmdbService {

    OmdbSearchResultDto searchMoviesFromOmdb(String title);

    MovieImdbDetailsDto getMovieDetailsFromImdb(String imdbId);

}
