package com.example.boardsideproject.domain.board.service;

import com.example.boardsideproject.dto.BoardResponseDto;
import com.example.boardsideproject.dto.TagsCreateRequestDto;

public interface BoardService {
    BoardResponseDto getBoard(Long id);

    void deleteTagsByBoardId(long boardId);

    void createBoard(TagsCreateRequestDto dto);

    BoardResponseDto getBoardTagsEntity(Long id);

    void addTags(TagsCreateRequestDto dto);

    void addTagsEntity(TagsCreateRequestDto dto);
}
