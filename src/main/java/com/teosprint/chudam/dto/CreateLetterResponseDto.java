package com.teosprint.chudam.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateLetterResponseDto {
    private Long letterId;

    public static CreateLetterResponseDto from(Long letterId) {
        return CreateLetterResponseDto.builder()
                .letterId(letterId)
                .build();
    }
}
