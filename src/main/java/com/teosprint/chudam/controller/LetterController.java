package com.teosprint.chudam.controller;

import com.teosprint.chudam.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;
}
