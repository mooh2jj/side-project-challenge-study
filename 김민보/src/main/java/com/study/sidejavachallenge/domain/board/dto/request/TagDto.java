package com.study.sidejavachallenge.domain.board.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TagDto {

    private String titleKor;
    private String titleEng;

    @Builder
    public TagDto(String titleKor, String titleEng) {
        this.titleKor = titleKor;
        this.titleEng = titleEng;
    }
}
