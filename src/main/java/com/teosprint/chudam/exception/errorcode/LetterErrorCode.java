package com.teosprint.chudam.exception.errorcode;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum LetterErrorCode implements ErrorCode{
    DOES_NOT_EXIST_LETTER(HttpStatus.NOT_FOUND, "요청한 편지 정보가 존재하지 않습니다.");

    private HttpStatus status;
    private String message;

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
