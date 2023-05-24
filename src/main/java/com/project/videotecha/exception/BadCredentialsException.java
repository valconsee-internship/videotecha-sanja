package com.project.videotecha.exception;

public class BadCredentialsException extends ApiBadRequestException {
    public BadCredentialsException(String message) {
        super(message);
    }
}
