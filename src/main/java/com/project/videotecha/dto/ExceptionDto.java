package com.project.videotecha.dto;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ExceptionDto {
    private String message;
    private Timestamp timestamp;
    private int httpStatus;
    private HttpStatus httpMessage;

    public ExceptionDto(String message, Timestamp timestamp, int httpStatus, HttpStatus httpMessage) {
        this.message = message;
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
        this.httpMessage = httpMessage;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public HttpStatus getHttpMessage() {
        return httpMessage;
    }
}
