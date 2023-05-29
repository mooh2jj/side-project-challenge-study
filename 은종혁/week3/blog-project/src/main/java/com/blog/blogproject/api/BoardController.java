package com.blog.blogproject.api;

import com.blog.blogproject.application.BoardService;
import com.blog.blogproject.dto.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController("/api/v1/board")
public class BoardController {

    public BoardService boardService;

    @GetMapping("/tags")
    public ResponseEntity<List<BoardResponse>> getByTags(@RequestParam List<Long> tags) {

        return new ResponseEntity<>(boardService.getByTags(tags), HttpStatus.OK);
    }
}
