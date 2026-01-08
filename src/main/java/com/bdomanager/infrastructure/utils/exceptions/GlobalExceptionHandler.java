package com.bdomanager.Infrastructure.utils.exceptions;

import com.bdomanager.Infrastructure.utils.exceptions.items.ItemAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ItemAlreadyExists.class})
    public ResponseEntity<String> handleItemAlreadyExistsException(ItemAlreadyExists exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
