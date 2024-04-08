package com.teosprint.chudam.service;


import com.teosprint.chudam.dto.CreateLetterRequestDto;
import com.teosprint.chudam.dto.CreateLetterResponseDto;
import com.teosprint.chudam.dto.LetterInfoResponseDto;

public interface LetterService {

    // 편지 조회
    LetterInfoResponseDto getLetter(Long letterId);
    CreateLetterResponseDto createLetter(CreateLetterRequestDto createLetterRequest);
}
