package com.teosprint.chudam.config.s3;

import lombok.Getter;

@Getter
public class AwsS3Exception extends RuntimeException{
    private final AwsS3ErrorCode awsS3ErrorCode;


    public AwsS3Exception(AwsS3ErrorCode awsS3ErrorCode) {
        super(awsS3ErrorCode.getMessage());
        this.awsS3ErrorCode = awsS3ErrorCode;
    }
}
