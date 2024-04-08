package com.teosprint.chudam.service;

import com.teosprint.chudam.domain.Letter;
import com.teosprint.chudam.dto.AwsS3FileResponseDto;
import com.teosprint.chudam.dto.CreateLetterRequestDto;
import com.teosprint.chudam.dto.CreateLetterResponseDto;
import com.teosprint.chudam.dto.LetterInfoResponseDto;
import com.teosprint.chudam.exception.custom.LetterCustomException;
import com.teosprint.chudam.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;
    private final AwsS3Service awsS3Service;

    @Override
    public LetterInfoResponseDto getLetter(Long letterId) {
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(() -> LetterCustomException.DOES_NOT_EXIST_LETTER);

        LetterInfoResponseDto letterInfoResponse = LetterInfoResponseDto.from(letter.getLetterImageUrl());
        return letterInfoResponse;
    }

    @Override
    public CreateLetterResponseDto createLetter(CreateLetterRequestDto createLetterRequest) {
        try{
            MultipartFile multipartFile = createLetterRequest.getLetterImage();
            if(multipartFile != null){
                AwsS3FileResponseDto response = awsS3Service.uploadFile(multipartFile);
                Letter letter = letterRepository.save(Letter.createLetter(response.getUrl(), LocalDateTime.now()));
                log.info("저장된 링크 : [{}]", letter.getLetterImageUrl());
                log.info("저장된 파일 : [{}]", multipartFile);

                CreateLetterResponseDto createLetterResponseDto = CreateLetterResponseDto.from(letter.getId());

                return createLetterResponseDto;
            }
        } catch (Exception e){
            e.printStackTrace();
            // 예외처리
        }
        return null;
    }
}
