package com.employee_api.api.Exceptions.AdviceException;

import javax.validation.constraints.Null;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee_api.api.Exceptions.EmployeeNotFoundException;
import com.employee_api.api.Exceptions.Dto.ApiError;


@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotFoundException exception){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Employee for ID: " + exception.getId() + " Not Found" );
        return new ResponseEntity<Object>(apiError,new HttpHeaders(), apiError.getStatus());
    }
}