package com.programmingdevesh.inventoryservice.advice;

import com.programmingdevesh.inventoryservice.CustomExceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InventoryServiceExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleItemNotFoundException(ItemNotFoundException itemNotFoundException){
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("NOT FOUND ERROR", itemNotFoundException.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }


}
