package com.blog.blogproject.repository;

import  com.blog.blogproject.domain.Board;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.blog.blogproject.domain.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;


    @Override
    public List<Board> findByTag(List<Long> tags) {

        BooleanBuilder builder = new BooleanBuilder();
        for (Long tag : tags) {
            builder.and(board.tags.get(0).tag.id.eq(tag));
        }

        return queryFactory
                .selectFrom(board)
                .where(builder)
                .fetch();
    }
}
