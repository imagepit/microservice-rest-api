package com.microservice.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler
        extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleAllIllegalArgumentException(Exception ex, WebRequest request) {
        return super.handleExceptionInternal(ex, new RequestError(100,ex.getMessage()), null, HttpStatus.BAD_REQUEST, request);
    }
}
