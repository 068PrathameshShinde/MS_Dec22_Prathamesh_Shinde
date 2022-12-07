package com.morningstar.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value="${data.exception.message2}")
    private String message2;
 
    
    @ExceptionHandler (value = EmployeeNotFounds.class)
    public ResponseEntity<String> EmployeeNotFound(EmployeeNotFounds employeeNotFound) {
        return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=InvalidLoginDetails.class)
    public ResponseEntity<String> invalidLoginDetails(InvalidLoginDetails InvalidLoginDetail)
    {
    	return new ResponseEntity<String>(message2,HttpStatus.NOT_FOUND);
    }
}
