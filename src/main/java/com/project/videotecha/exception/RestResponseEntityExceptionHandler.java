package com.project.videotecha.exception;

import com.project.videotecha.dto.ExceptionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
    @ExceptionHandler(value = ApiBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionDto handleBadRequestException(RuntimeException e) {
        logger.error("Error occurred", e);
        return new ExceptionDto(e.getMessage(), Instant.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFoundException(EntityNotFoundException e) {
        logger.error("Entity not found", e);
        return new ExceptionDto(e.getMessage(), Instant.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ExceptionDto handleMethodValidationFailure(MethodArgumentNotValidException ex) {
        StringBuilder b = new StringBuilder();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> b.append(e.getDefaultMessage()).append(";"));
        logger.error("Error occurred ",ex);
        return new ExceptionDto(b.toString(), Instant.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmailNotSentException.class)
    public ExceptionDto handleEmailNotSentException(EmailNotSentException e) {
        logger.error("Error occurred",e);
        return new ExceptionDto(e.getMessage(), Instant.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
