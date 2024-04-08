package com.teosprint.chudam.service;

import com.teosprint.chudam.domain.Letter;
import com.teosprint.chudam.dto.LetterInfoResponseDto;
import com.teosprint.chudam.exception.custom.LetterCustomException;
import com.teosprint.chudam.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;

    @Override
    public LetterInfoResponseDto getLetter(Long letterId) {
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(() -> LetterCustomException.DOES_NOT_EXIST_LETTER);

        LetterInfoResponseDto letterInfoResponse = LetterInfoResponseDto.from(letter.getLetterImageUrl());
        return letterInfoResponse;
    }
}
