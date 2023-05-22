package com.project.videotecha.dto;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ExceptionDto {
    private String message;
    private Instant timestamp;
    private int httpStatus;
    private HttpStatus httpMessage;

    public ExceptionDto(String message, Instant timestamp, int httpStatus, HttpStatus httpMessage) {
        this.message = message;
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
        this.httpMessage = httpMessage;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public HttpStatus getHttpMessage() {
        return httpMessage;
    }
}
