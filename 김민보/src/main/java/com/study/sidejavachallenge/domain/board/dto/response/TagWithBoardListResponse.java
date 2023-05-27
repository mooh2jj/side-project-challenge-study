package com.study.sidejavachallenge.domain.board.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public class TagWithBoardListResponse {

    private final String titleKor;
    private final String titleEng;
    private final List<BoardResponse> boards;

    @Builder
    public TagWithBoardListResponse(String titleKor, String titleEng, List<BoardResponse> boards) {
        this.titleKor = titleKor;
        this.titleEng = titleEng;
        this.boards = boards;
    }
}
