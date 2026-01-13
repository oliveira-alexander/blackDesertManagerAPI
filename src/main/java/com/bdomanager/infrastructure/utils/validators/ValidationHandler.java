package com.bdomanager.infrastructure.utils.validators;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidatorOutputDTO> validatorHandler(MethodArgumentNotValidException exception){
        List<String> messages = new ArrayList<>();

        exception.getFieldErrors()
                 .stream()
                .forEach(field -> messages.add(field.getDefaultMessage()));

        ValidatorOutputDTO response = new ValidatorOutputDTO(LocalDateTime.now(),
                                                             messages);

        return new ResponseEntity<ValidatorOutputDTO>(response, HttpStatus.BAD_REQUEST);
    }
}
