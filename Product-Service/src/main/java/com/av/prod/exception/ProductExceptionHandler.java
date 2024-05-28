package com.av.prod.exception;

import com.av.prod.dtos.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice ///**  its part of spring MVC and, store response body by default **/
public class ProductExceptionHandler {
    @Autowired
    private ErrorDTO errorDTO;

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException ex , WebRequest webRequest){

        errorDTO.setMessage(ex.getMessage());
        errorDTO.setErrorCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorDTO,HttpStatus.NOT_FOUND);
    }
}