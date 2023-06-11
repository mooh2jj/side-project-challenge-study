package com.study.sidejavachallenge.domain.board.dto.response;

import com.study.sidejavachallenge.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BoardWithCategoryDto {

    private final Long id;        // boardId
    private final String title;   // boardTitle
    private final String majorCategoryTitle;
    private final String subCategoryTitle;
    private final String minorCategoryTitle;
    private final String minimumCategoryTitle;

    public static BoardWithCategoryDto mapToDto(Board board) {
        return BoardWithCategoryDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .majorCategoryTitle(board.getMajorCategoryTitle())
                .subCategoryTitle(board.getSubCategoryTitle())
                .minorCategoryTitle(board.getMinorCategoryTitle())
                .minimumCategoryTitle(board.getMinimumCategoryTitle())
                .build();
    }
}
