package com.study.sidejavachallenge.domain.board.dto.response;

import com.study.sidejavachallenge.domain.board.entity.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TagResponse {

    private final Long tagId;
    private final String titleKor;
    private final String titleEng;

    @Builder
    public TagResponse(Long tagId, String titleKor, String titleEng) {
        this.tagId = tagId;
        this.titleKor = titleKor;
        this.titleEng = titleEng;
    }

     public static TagResponse mapToDto(Tag tag) {
        return TagResponse.builder()
                .tagId(tag.getId())
                .titleKor(tag.getTitleKor())
                .titleEng(tag.getTitleEng())
                .build();
    }
}
