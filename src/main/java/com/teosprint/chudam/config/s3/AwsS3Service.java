package com.teosprint.chudam.config.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwsS3Service {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String createFileName(String originalFileName){
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String fileName){
        List<String> allowedExtensions = Arrays.asList(".jpg", ".jpeg", ".png", ".svg");

        if (fileName.lastIndexOf("." ) == -1) {
            throw new AwsS3Exception(AwsS3ErrorCode.INVALID_EXTENSION);
        }

        String extension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        if (!allowedExtensions.contains(extension)) {
            throw new AwsS3Exception(AwsS3ErrorCode.INVALID_EXTENSION);
        }

        return extension;
    }
}
