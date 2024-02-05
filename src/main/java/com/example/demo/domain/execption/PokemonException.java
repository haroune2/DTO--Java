package com.example.demo.domain.execption;

import org.springframework.http.HttpStatus;

public class PokemonException extends RuntimeException{
    private HttpStatus  httpStatus;

    public PokemonException(HttpStatus httpStatus, String message) {
        super(message); 
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    } 
}
