package com.study.sidejavachallenge.domain.board.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.entity.Category;
import com.study.sidejavachallenge.domain.board.entity.QCategoryBridge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;
import static com.study.sidejavachallenge.domain.board.entity.QBoard.*;
import static com.study.sidejavachallenge.domain.board.entity.QCategoryBridge.*;
import static com.study.sidejavachallenge.domain.board.entity.QCategory.*;

@Slf4j
@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardWithCategoryDto> findBoards(BoardRequestDto boardRequestDto) {

        return queryFactory
                .selectFrom(board)
                .leftJoin(board.categoryBridges, categoryBridge).fetchJoin()
                .where(
                        getSearch(boardRequestDto)
                )
                .fetch()
                .stream()
                .distinct()
                .map(BoardWithCategoryDto::mapToDto)
                .collect(Collectors.toList());
    }

    private BooleanBuilder getSearch(BoardRequestDto boardRequestDto) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(!ObjectUtils.isEmpty(boardRequestDto.getCategoryIds())) {
            log.info("boardRequestDto.getCategoryIds(): {}", boardRequestDto.getCategoryIds());
            booleanBuilder.and(categoryBridge.category.id.in(boardRequestDto.getCategoryIds()));
        }

        return booleanBuilder;
    }
}
