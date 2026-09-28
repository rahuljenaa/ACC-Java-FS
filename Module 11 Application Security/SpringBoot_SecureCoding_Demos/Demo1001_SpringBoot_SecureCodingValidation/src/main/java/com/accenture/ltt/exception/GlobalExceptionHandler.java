package com.accenture.ltt.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put(
            "errors",
            ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                    err -> err.getField(),
                    err -> err.getDefaultMessage(),
                    (a, b) -> a
                ))
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put(
            "errors",
            ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                    v -> v.getPropertyPath().toString(),
                    v -> v.getMessage(),
                    (a, b) -> a
                ))
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBindException(BindException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put(
            "errors",
            ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                    err -> err.getField(),
                    err -> err.getDefaultMessage(),
                    (a, b) -> a
                ))
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}


