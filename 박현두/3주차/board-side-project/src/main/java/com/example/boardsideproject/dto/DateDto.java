package com.example.boardsideproject.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class DateDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;

}
