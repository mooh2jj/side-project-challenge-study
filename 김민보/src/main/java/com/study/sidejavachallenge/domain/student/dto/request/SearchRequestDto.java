package com.study.sidejavachallenge.domain.student.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchRequestDto {

    private String name;
    private String title;
}
