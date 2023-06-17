package com.study.sidejavachallenge.domain.board.repository;

import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.entity.Category;

import java.util.List;

public interface BoardRepositoryCustom {

    List<BoardWithCategoryDto> findBoards(BoardRequestDto boardRequestDto);
}
