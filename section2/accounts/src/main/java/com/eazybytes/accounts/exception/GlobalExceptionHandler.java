package com.eazybytes.accounts.exception;

import com.eazybytes.accounts.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false),
                HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }
}
