package com.example.nobsv2.exceptions;


import com.example.nobsv2.product.model.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception){

        return new ErrorResponse(exception.getMessage());

    }

    @ExceptionHandler(ProductNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleProductNotValidException(ProductNotValidException exception){

        return new ErrorResponse((exception.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleProductNotValidConstraints(ConstraintViolationException exception){
        //Returns only the first error
        return new ErrorResponse((exception.getConstraintViolations().iterator().next().getMessage()));
    }
    //Can add more exceptions
}
