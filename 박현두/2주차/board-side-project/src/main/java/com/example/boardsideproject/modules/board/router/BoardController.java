package com.example.boardsideproject.modules.board.router;

import com.example.boardsideproject.dto.BoardResponseDto;
import com.example.boardsideproject.modules.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("{id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }
}
