package com.project.videotecha.exception;

public class OverlappingWithExistingProjectionsException extends ApiBadRequestException {
    public OverlappingWithExistingProjectionsException(String message) {
        super(message);
    }
}
