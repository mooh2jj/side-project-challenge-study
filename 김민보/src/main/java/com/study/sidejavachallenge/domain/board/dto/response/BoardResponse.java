package com.study.sidejavachallenge.domain.board.dto.response;

import com.study.sidejavachallenge.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;

    @Builder
    public BoardResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BoardResponse mapToDto(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
