package com.blog.blogproject.repository;

import com.blog.blogproject.domain.Board;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findByTag(List<Long> tags);
}
