package com.dnrea.edu.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnrea.edu.demo.dto.response.ApiResponse;

// tap chung xu ly cac luong ngoai le
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse<?>> handlingRuntimeException(RuntimeException runtimeException) {
        List<String> errors = new ArrayList<>();
        errors.add(runtimeException.getMessage());
        ApiResponse<?> request = new ApiResponse<>();
        request.setCode(500);
        request.setMessage(errors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(request);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse<?>> handlingAppException(AppException appException) {
        ErrorCode errorCode = appException.getErrorCode();
        List<String> errors = new ArrayList<>();
        errors.add(errorCode.getMessage());
        ApiResponse<?> request = new ApiResponse<>();
        request.setCode(errorCode.getCode());
        request.setMessage(errors);
        return ResponseEntity.status(errorCode.getStatusCode()).body(request);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse<?>> handlingException(Exception exception) {
        List<String> errors = new ArrayList<>();
        errors.add(exception.getMessage());
        errors.add(exception.getClass().getSimpleName());
        ApiResponse<?> request = new ApiResponse<>();
        request.setCode(500);
        request.setMessage(errors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(request);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse<?>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<String> errors = new ArrayList<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        ApiResponse<?> request = new ApiResponse<>();
        request.setCode(1003);
        request.setMessage(errors);
        return ResponseEntity.badRequest().body(request);
    }

    // @ExceptionHandler(value = AccessDeniedException.class)
    // ResponseEntity<ApiResponse<?>> accessDeniedException(AccessDeniedException
    // adException) {
    // List<String> errors = new ArrayList<>();
    // errors.add(adException.getMessage());
    // ApiResponse<?> request = new ApiResponse<>();
    // request.setCode(1010);
    // request.setMessage(errors);
    // return ResponseEntity.status(HttpStatus.FORBIDDEN).body(request);
    // }

}
