package com.programmingdevesh.orderservice.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderServiceExceptionsHandler {

    //Not defined any custom Exceptions yet so defining the generic handler for now
    @ExceptionHandler
    public String GenericExceptionHandler(Exception exception){
        return exception.getMessage();
    }

}
