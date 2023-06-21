package com.study.sidejavachallenge.domain.board.dto.request;

import com.study.sidejavachallenge.domain.board.entity.CategoryStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryDto {

    private String logo;
    private String ord;
    private Long parentId;
    private String title;
    private CategoryStatus status;

    @Builder
    public CategoryDto(String logo, String ord, Long parentId ,String title, CategoryStatus status) {
        this.logo = logo;
        this.ord = ord;
        this.parentId = parentId;
        this.title = title;
        this.status = status;
    }
}
