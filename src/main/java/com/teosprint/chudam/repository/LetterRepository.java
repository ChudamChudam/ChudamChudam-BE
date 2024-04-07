package com.teosprint.chudam.repository;

import com.teosprint.chudam.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}
