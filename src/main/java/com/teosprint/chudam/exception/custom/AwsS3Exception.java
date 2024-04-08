package com.teosprint.chudam.exception.custom;
import com.teosprint.chudam.exception.custom.CustomException;
import com.teosprint.chudam.exception.errorcode.AwsS3ErrorCode;
import lombok.Getter;

@Getter
public class AwsS3Exception extends CustomException {
    public AwsS3Exception(AwsS3ErrorCode awsS3ErrorCode) {
        super(awsS3ErrorCode);
    }
}