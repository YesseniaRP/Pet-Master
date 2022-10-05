package com.project.projectpet.controller;

import com.project.projectpet.exceptions.ClienteMascotaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteMascotaControllerExceptionHandler {

    @ExceptionHandler(ClienteMascotaException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleClienteMascota(ClienteMascotaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getCode()));
    }

}
