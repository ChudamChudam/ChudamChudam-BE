package com.teosprint.chudam.controller;

import com.teosprint.chudam.dto.LetterInfoResponseDto;
import com.teosprint.chudam.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    // 편지 조회
    @GetMapping("/api/letter/{letterId}")
    public ResponseEntity<LetterInfoResponseDto> getLetter(@PathVariable Long letterId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(letterService.getLetter(letterId));
    }
}
