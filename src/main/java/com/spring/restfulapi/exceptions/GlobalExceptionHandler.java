package com.spring.restfulapi.exceptions;

import com.spring.restfulapi.errorHandler.MyErrorResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {




    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,MyErrorResponses>> handleHandler(IllegalArgumentException exception){

        MyErrorResponses responses= new MyErrorResponses();
        responses.setErrorCode("400");
        responses.setMessage(exception.getMessage());
        responses.setTime(new Date(2025,11,28 ,15,05));


        Map<String,MyErrorResponses> errorMap = new HashMap<>();

        errorMap.put("error", responses);
        return ResponseEntity.status(400).body(errorMap);

    }
}
