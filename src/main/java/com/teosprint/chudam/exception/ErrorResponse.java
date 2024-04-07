package com.teosprint.chudam.exception;

import com.teosprint.chudam.exception.errorcode.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private HttpStatus status;
    private String message;

    public static ErrorResponse errorResponse(ErrorCode errorCode) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.status = errorCode.getStatus();
        errorResponse.message = errorCode.getMessage();

        return errorResponse;
    }

    public static ErrorResponse errorResponse(HttpStatus status, String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.status = status;
        errorResponse.message = message;

        return errorResponse;
    }
}
