package com.teosprint.chudam.controller;

import com.teosprint.chudam.dto.CreateLetterRequestDto;
import com.teosprint.chudam.dto.CreateLetterResponseDto;
import com.teosprint.chudam.dto.LetterInfoResponseDto;
import com.teosprint.chudam.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/letter")
    public ResponseEntity<CreateLetterResponseDto> uploadLetter(@ModelAttribute CreateLetterRequestDto createLetterRequest){

        return ResponseEntity.status(HttpStatus.OK)
                .body(letterService.createLetter(createLetterRequest));
    }

}
