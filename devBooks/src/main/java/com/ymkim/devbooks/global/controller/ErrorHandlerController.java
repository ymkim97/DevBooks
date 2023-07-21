package com.ymkim.devbooks.global.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> catchDuplicateBookTitle(Exception e) {
        return ResponseEntity.badRequest().body("Duplicated Book Title!!!");
    }
}
