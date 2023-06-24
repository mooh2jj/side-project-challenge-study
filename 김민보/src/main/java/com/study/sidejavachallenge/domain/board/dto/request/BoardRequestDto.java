package com.study.sidejavachallenge.domain.board.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardRequestDto {

    List<Long> categoryIds;

    @Builder
    public BoardRequestDto(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
