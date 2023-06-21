package com.study.sidejavachallenge.domain.board.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardCreateRequestDto {

    private String title;    // boardTitle
    private String content;  // boardContent
    private List<TagDto> tags;
    private List<CategoryDto> categories;

    @Builder
    public BoardCreateRequestDto(String title, String content, List<TagDto> tags, List<CategoryDto> categories) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.categories = categories;
    }
}
