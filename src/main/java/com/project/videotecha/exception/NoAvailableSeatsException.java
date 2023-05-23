package com.project.videotecha.exception;

public class NoAvailableSeatsException extends ApiBadRequestException {
    public NoAvailableSeatsException(String message) {
        super(message);
    }
}
