package com.study.sidejavachallenge.domain.board.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryRequestDto {

    @NotNull(message = "카테고리 제목은 필수값입니다.")
    private String categoryTitle;

    @Builder
    public CategoryRequestDto(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
