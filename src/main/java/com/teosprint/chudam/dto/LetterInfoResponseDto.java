package com.teosprint.chudam.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LetterInfoResponseDto {

    private String letterImageUrl;

    public static LetterInfoResponseDto from(String letterImageUrl) {
        return LetterInfoResponseDto.builder()
                .letterImageUrl(letterImageUrl)
                .build();
    }
}
