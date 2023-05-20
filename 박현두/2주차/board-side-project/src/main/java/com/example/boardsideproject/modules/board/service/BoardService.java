package com.example.boardsideproject.modules.board.service;

import com.example.boardsideproject.dto.BoardResponseDto;

public interface BoardService {
    BoardResponseDto getBoard(Long id);
}
