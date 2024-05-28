package com.av.prod.exception;

import com.av.prod.dtos.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalProdExceptionHandler  {

    @Autowired
    private ErrorDTO errorDTO;


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        // Log the exception
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setErrorCode(HttpStatus.BAD_REQUEST.value());
        // Return an error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDTO);
    }



    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ProductNotFoundException ex) {
        // Log the exception
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setErrorCode(HttpStatus.BAD_REQUEST.value());

        // Return a custom error response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
