package com.mrizkisaputra.controllers;

import com.mrizkisaputra.model.response.ApiError;
import com.mrizkisaputra.model.response.ApiSubError;
import com.mrizkisaputra.model.response.ApiValidationError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> constraintViolationException(ConstraintViolationException err) {
        List<ApiSubError> validationError = new ArrayList<>();
        for (ConstraintViolation<?> violation : err.getConstraintViolations()) {
            ApiValidationError build = ApiValidationError.builder()
                    .object(violation.getRootBeanClass().getName())
                    .field(violation.getPropertyPath().toString())
                    .rejectedValue(violation.getInvalidValue())
                    .message(violation.getMessage())
                    .build();
            validationError.add(build);
        }
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, err.getMessage(), err);
        apiError.setSubErrors(validationError);
        return buildResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> responseStatusException(ResponseStatusException err) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, err.getReason(), err);
        return buildResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError, HttpStatus httpStatus) {
        return new ResponseEntity<>(apiError, httpStatus);
    }
}
