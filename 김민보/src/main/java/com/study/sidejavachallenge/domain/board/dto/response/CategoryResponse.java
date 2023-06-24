package com.study.sidejavachallenge.domain.board.dto.response;

import com.study.sidejavachallenge.domain.board.entity.Category;
import com.study.sidejavachallenge.domain.board.entity.CategoryStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@ToString
public class CategoryResponse {

    private final Long id;
    private final String title;
    private final String ord;
    private final String logo;
    private final CategoryStatus status;

    @Builder
    public CategoryResponse(Long id, String title, String ord, String logo, CategoryStatus status) {
        this.id = id;
        this.title = title;
        this.ord = ord;
        this.logo = logo;
        this.status = status;
    }

    static public CategoryResponse mapToDto(Category category) {

        return CategoryResponse.builder()
                .id(category.getId())
                .title(category.getTitle())
                .ord(category.getOrd())
                .logo(category.getLogo())
                .status(category.getStatus())
                .build();
    }
}
