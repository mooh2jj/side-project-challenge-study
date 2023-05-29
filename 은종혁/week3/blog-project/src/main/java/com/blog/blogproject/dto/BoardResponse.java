package com.blog.blogproject.dto;

import com.blog.blogproject.domain.Board;
import com.blog.blogproject.domain.Tag;
import com.blog.blogproject.domain.TagBridge;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BoardResponse {

    private String title;
    private String contents;
    private List<TagBridge> tags;

    @Builder
    public BoardResponse(String title, String contents, List<TagBridge> tags) {
        this.title = title;
        this.contents = contents;
        this.tags = tags;
    }

    public static BoardResponse mapToDto(Board board) {
        return BoardResponse.builder()
                .title(board.getTitle())
                .contents(board.getContents())
                .tags(board.getTags())
                .build();
    }
}
