package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.BoardCreateRequestDto;
import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardResponse;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import java.util.List;

public interface BoardService {

//    List<BoardResponse> getBoard(Long boardId);
    BoardWithTagListResponse getBoard(Long boardId);

    // boardId를 통해 최대 4뎁스를 갖는 category 출력하기
    BoardWithCategoryDto getBoardWithCategory(Long boardId);

    // 요청파라미터를 categoryList(categoryIds=1,2,3,4)로 보내고 반환은 boardList로 받기
    List<BoardWithCategoryDto> getCategoriesByBoardId(BoardRequestDto boardRequestDto);

    // Board 생성시 태그, 카테고리 4개까지 등록하기
    BoardResponse createBoard(BoardCreateRequestDto boardCreateRequestDto);
}