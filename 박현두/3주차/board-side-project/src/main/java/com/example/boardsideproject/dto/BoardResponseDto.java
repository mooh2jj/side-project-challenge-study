package com.example.boardsideproject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BoardResponseDto {
    private final String title;
    private final String content;
    private final List<String> tags;

    @Builder
    public BoardResponseDto(String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
}
