package com.project.videotecha.exception;

public class MovieHasFutureProjectionsException extends ApiBadRequestException {
    public MovieHasFutureProjectionsException(String message) {
        super(message);
    }
}
