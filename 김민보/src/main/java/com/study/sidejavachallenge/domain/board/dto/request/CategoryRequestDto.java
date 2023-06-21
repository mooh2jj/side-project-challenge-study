package com.study.sidejavachallenge.domain.board.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryRequestDto {

    private String categoryTitle;

    @Builder
    public CategoryRequestDto(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
