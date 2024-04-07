package com.teosprint.chudam.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "letter_id")
    private Long id;

    @Column(name = "letter_link")
    private String letterLink;

    @Column(name = "letter_image_url")
    private String letterImageUrl;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    public static Letter createLetter(String letterImageUrl, LocalDateTime createDate) {
        Letter letter = new Letter();
        letter.letterImageUrl = letterImageUrl;
        letter.createDate = createDate;

        return letter;
    }
}
