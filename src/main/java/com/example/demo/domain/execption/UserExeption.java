package com.example.demo.domain.execption;

import org.springframework.http.HttpStatus;

public class UserExeption extends RuntimeException {

    private HttpStatus  httpStatus;

    public UserExeption(HttpStatus httpStatus, String message) {
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
