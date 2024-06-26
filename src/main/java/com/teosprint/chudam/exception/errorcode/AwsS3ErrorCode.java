package com.teosprint.chudam.exception.errorcode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AwsS3ErrorCode implements ErrorCode {
    INVALID_EXTENSION("[확장자오류] : jpg, jpeg, svg, png 파일만 등록 가능합니다", HttpStatus.BAD_REQUEST),
    EMPTY_UPLOAD_FILE("[빈파일오류] : 업로드 파일이 없습니다", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;

    @Override
    public HttpStatus getStatus() {
        return this.httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}