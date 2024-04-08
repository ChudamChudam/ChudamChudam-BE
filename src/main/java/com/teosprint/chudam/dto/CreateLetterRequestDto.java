package com.teosprint.chudam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Builder
@Getter
public class CreateLetterRequestDto {

    private String letterImage;
}
