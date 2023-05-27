package com.study.sidejavachallenge.domain.student.dto.request;

import lombok.*;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LottoRequestDto {

    @Min(1)
    private int num;

    @Builder
    public LottoRequestDto(int num) {
        this.num = num;
    }
}
