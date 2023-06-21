package com.study.sidejavachallenge.domain.board.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.sidejavachallenge.domain.board.dto.request.CategoryRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;
import com.study.sidejavachallenge.domain.board.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.study.sidejavachallenge.domain.board.entity.QCategory.category;

@Slf4j
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryResponse> findCategory(CategoryRequestDto categoryRequestDto) {

        return queryFactory
                .selectFrom(category)
                .where(
                        eqTitle(categoryRequestDto.getCategoryTitle())
                )
                .stream().filter(category -> Arrays.stream(category.getOrd().split("\\.")).map(Integer::parseInt).count() >= 3)
                .map(CategoryResponse::mapToDto)
                .collect(Collectors.toList());
    }

    private BooleanExpression eqTitle(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }

        return category.title.like("%"+title+"%");
    }
}
