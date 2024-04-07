package com.teosprint.chudam.config.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    @PostMapping("/uploadFile")
    public ResponseEntity<AwsS3FileResponse> uploadFile(MultipartFile multipartFile){

        return ResponseEntity.ok(awsS3Service.uploadFile(multipartFile));
    }
}
