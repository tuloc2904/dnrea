package com.dnrea.edu.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// ma loi
public enum ErrorCode {
    USER_EXISTED(1001, "user-exists", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1005, "user-not-found", HttpStatus.BAD_REQUEST),
    LOGIN_FAIL(1006, "Login-FAIL", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(1007, "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(1020, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED);

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
