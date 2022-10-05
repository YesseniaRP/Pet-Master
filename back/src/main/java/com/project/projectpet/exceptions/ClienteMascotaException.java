package com.project.projectpet.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ClienteMascotaException extends RuntimeException{

    private final String code;
    private final HttpStatus status;
    private final String message;

    public ClienteMascotaException(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
