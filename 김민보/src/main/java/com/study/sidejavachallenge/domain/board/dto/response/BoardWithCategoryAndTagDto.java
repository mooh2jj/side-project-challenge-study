package com.study.sidejavachallenge.domain.board.dto.response;

import com.study.sidejavachallenge.domain.board.dto.request.CategoryDto;
import com.study.sidejavachallenge.domain.board.dto.request.TagDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public class BoardWithCategoryAndTagDto {

    private final String title;    // boardTitle
    private final String content;  // boardContent
    private final List<TagDto> tags;
    private final List<CategoryDto> categories;

    @Builder
    public BoardWithCategoryAndTagDto(String title, String content, List<TagDto> tags, List<CategoryDto> categories) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.categories = categories;
    }
}
