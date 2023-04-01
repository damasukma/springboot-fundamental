package com.employee_api.api.Exceptions.Dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ApiError{
   
    @Getter
    private HttpStatus status;
    @Getter
    private String message;
    
    
    public ApiError(HttpStatus status, String message){
        super();
        this.status = status;
        this.message = message;
    }


}
