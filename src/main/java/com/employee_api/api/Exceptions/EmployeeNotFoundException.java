package com.employee_api.api.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    @Getter
    private int id;
    
    public EmployeeNotFoundException(int id){
        this.id = id;
    }
    public EmployeeNotFoundException(){}

  
}
