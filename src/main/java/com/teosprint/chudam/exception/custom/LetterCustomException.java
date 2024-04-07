package com.teosprint.chudam.exception.custom;

import com.teosprint.chudam.exception.errorcode.ErrorCode;
import com.teosprint.chudam.exception.errorcode.LetterErrorCode;

public class LetterCustomException extends CustomException{

    public static final LetterCustomException DOES_NOT_EXIST_LETTER =
            new LetterCustomException(LetterErrorCode.DOES_NOT_EXIST_LETTER);

    public LetterCustomException(ErrorCode errorCode) {
        super(errorCode);
    }
}
