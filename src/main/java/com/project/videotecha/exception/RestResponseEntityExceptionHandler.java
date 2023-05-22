package com.project.videotecha.exception;

import com.project.videotecha.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionDto handleBadRequestException(RuntimeException e) {
        return new ExceptionDto(e.getMessage(), Instant.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFoundException(EntityNotFoundException e) {
        return new ExceptionDto(e.getMessage(), Instant.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public String handleMethodValidationFailure(final MethodArgumentNotValidException ex) {
        StringBuilder b = new StringBuilder();
        BindingResult results = ex.getBindingResult();
        for (FieldError e : results.getFieldErrors()) {
            b.append(e.getDefaultMessage()).append("\n");
        }
        return b.toString();
    }
}
