package com.project.videotecha.exception;

public class BusinessRuleException extends ApiBadRequestException {
    public BusinessRuleException(String message) {
        super(message);
    }
}
