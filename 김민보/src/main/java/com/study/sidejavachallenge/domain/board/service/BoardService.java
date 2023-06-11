package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;

public interface BoardService {

//    List<BoardResponse> getBoard(Long boardId);
    BoardWithTagListResponse getBoard(Long boardId);

    BoardWithCategoryDto getBoardWithCategory(Long boardId);
}