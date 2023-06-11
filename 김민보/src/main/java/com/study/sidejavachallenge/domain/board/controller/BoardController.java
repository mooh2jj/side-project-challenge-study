package com.study.sidejavachallenge.domain.board.controller;

import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api/boards/{boardId}/category")
    public ResponseEntity<?> getBoardWithCategory(@PathVariable Long boardId) {

        BoardWithCategoryDto boardDto = boardService.getBoardWithCategory(boardId);
        log.info("boardDto = {}", boardDto);

        return ResponseEntity.ok(boardDto);
    }


}
