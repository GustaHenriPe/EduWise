package com.EduWise.EduWise.infra.presentation.handlers;

import com.EduWise.EduWise.core.domain.exceptions.DomainException;
import com.EduWise.EduWise.core.domain.exceptions.EntityNotFoundException;
import com.EduWise.EduWise.core.domain.exceptions.UserRoleNotAllowedException;
import com.EduWise.EduWise.infra.dtos.error.ErrorResponse;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UserRoleNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleUserRoleNotAllowed(UserRoleNotAllowedException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");
        ErrorResponse error = ErrorResponse.builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonParseException(HttpMessageNotReadableException ex) {
        String message = "Invalid JSON format or missing required fields";
        if (ex.getCause() instanceof MismatchedInputException) {
            MismatchedInputException cause = (MismatchedInputException) ex.getCause();
            message = "Required field missing: " + cause.getPath().get(0).getFieldName();
        }
        ErrorResponse error = ErrorResponse.builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        String message = "Invalid request parameter";
        if (ex.getMessage().contains("must not be null")) {
            message = "Required ID parameter is missing or null";
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorResponse> handlePropertyValue(PropertyValueException ex) {
        String message = "Required field cannot be null: " + ex.getPropertyName();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

//    // Captura erros de SQL constraint
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
//        String message = "Data integrity violation - required field is missing";
//        if (ex.getMessage().contains("NULL")) {
//            message = "Required field cannot be null";
//        }
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .message(message)
//                .status(HttpStatus.BAD_REQUEST.value())
//                .timestamp(LocalDateTime.now())
//                .build();
//        return ResponseEntity.badRequest().body(errorResponse);
//    }
}
