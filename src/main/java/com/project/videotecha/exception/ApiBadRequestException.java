package com.project.videotecha.exception;

public class ApiBadRequestException extends RuntimeException {
    public ApiBadRequestException(String message) {
        super(message);
    }
}
