package com.study.sidejavachallenge.domain.board.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardWithTagListResponse {

    private final String title;
    private final String content;
    private final List<TagResponse> tags;

    @Builder
    public BoardWithTagListResponse(String title, String content, List<TagResponse> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

}
