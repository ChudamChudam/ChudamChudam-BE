package com.teosprint.chudam.exception;

import com.teosprint.chudam.exception.custom.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 커스텀 예외 핸들러
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandle(CustomException customException) {
        final ErrorResponse errorResponse = ErrorResponse.errorResponse(customException.getErrorCode());
        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }

    // 필수 요청 파라미터 예외 핸들러
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> missingServletRequestParameterHandle(MissingServletRequestParameterException requestParameterException) {
        final ErrorResponse errorResponse = ErrorResponse.errorResponse(HttpStatus.BAD_REQUEST, "필수 요청 파라미터가 존재하지 않습니다.");
        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }
}
