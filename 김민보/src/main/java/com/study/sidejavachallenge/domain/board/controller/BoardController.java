package com.study.sidejavachallenge.domain.board.controller;

import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardResponse;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<BoardWithTagListResponse> getBoard(@PathVariable Long id) {

        BoardWithTagListResponse board = boardService.getBoard(id);
        log.info("board = {}", board);

        return ResponseEntity.ok(board);
    }

    // boardId를 통해 최대 4뎁스를 갖는 category 출력하기
    @GetMapping("/api/boards/{boardId}/category")
    public ResponseEntity<?> getBoardWithCategory(@PathVariable Long boardId) {

        BoardWithCategoryDto boardDto = boardService.getBoardWithCategory(boardId);
        log.info("boardDto = {}", boardDto);

        return ResponseEntity.ok(boardDto);
    }

    // 요청파라미터를 categoryList(categoryIds=1,2,3,4)로 보내고 반환은 boardList로 받기
    @GetMapping("/api/boards")
    public ResponseEntity<?> getBoardWithCategoryList(BoardRequestDto boardRequestDto) {

        List<BoardWithCategoryDto> categoriesByBoardId = boardService.getCategoriesByBoardId(boardRequestDto);

        return ResponseEntity.ok(categoriesByBoardId);
    }
}
