package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;

import java.util.List;

public interface BoardService {

//    List<BoardResponse> getBoard(Long boardId);
    BoardWithTagListResponse getBoard(Long boardId);

    BoardWithCategoryDto getBoardWithCategory(Long boardId);

    List<BoardWithCategoryDto> getCategoriesByBoardId(BoardRequestDto boardRequestDto);
}