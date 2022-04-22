package com.maersk.shipping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@ControllerAdvice
public class ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handle(ConstraintViolationException exception) {
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(errorMessage);
        return new ResponseEntity<ErrorResponseDto>(errorResponseDto, null, HttpStatus.BAD_REQUEST);
    }
}
