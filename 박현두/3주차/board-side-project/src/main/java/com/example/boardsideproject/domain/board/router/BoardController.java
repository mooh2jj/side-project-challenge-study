package com.example.boardsideproject.domain.board.router;

import com.example.boardsideproject.domain.tags.service.TagsService;
import com.example.boardsideproject.dto.BoardResponseDto;
import com.example.boardsideproject.domain.board.service.BoardService;
import com.example.boardsideproject.dto.TagsCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    @GetMapping("/{id}/tags-entity")
    public ResponseEntity<BoardResponseDto> getBoardTagsEntity(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardTagsEntity(id));
    }

    @PostMapping("/tags")
    public ResponseEntity<String> createTag(@RequestBody TagsCreateRequestDto dto) {
        boardService.addTagsEntity(dto);
        return ResponseEntity.ok().body("태그 생성에 성공하였습니다.");
    }

    @DeleteMapping("/tags")
    public ResponseEntity<String> deleteTag(long boardId) {
        boardService.deleteTagsByBoardId(boardId);
        return ResponseEntity.ok().body("태그 삭제에 성공하였습니다.");
    }
}
