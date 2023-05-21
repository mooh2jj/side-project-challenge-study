package com.study.sidejavachallenge.domain.board.controller;

import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagWithBoardListResponse;
import com.study.sidejavachallenge.domain.board.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/api/tags/{id}")
    public ResponseEntity<TagWithBoardListResponse> getTag(@PathVariable Long id) {

        TagWithBoardListResponse tag = tagService.getTag(id);
        log.info("tag = {}", tag);

        return ResponseEntity.ok(tag);
    }
}
