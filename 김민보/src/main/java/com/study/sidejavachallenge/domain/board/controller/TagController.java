package com.study.sidejavachallenge.domain.board.controller;

import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagWithBoardListResponse;
import com.study.sidejavachallenge.domain.board.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/api/tags/{tagId}")
    public ResponseEntity<TagWithBoardListResponse> getTag(@PathVariable Long tagId) {

        TagWithBoardListResponse tag = tagService.getTag(tagId);
        log.info("tag = {}", tag);

        return ResponseEntity.ok(tag);
    }

    // 태그 삭제 ( cascade = CascadeType.ALL 설정으로 자식엔티티인 TagBridge도 삭제됨)
    @DeleteMapping("/api/tags/{tagId}")
    public ResponseEntity<TagResponse> deleteTag(@PathVariable Long tagId) {
        log.info("TagController deleteTag() run");

        TagResponse deleteTag = tagService.deleteTag(tagId);
        log.info("deleteTag = {}", deleteTag);

        return ResponseEntity.ok(deleteTag);
    }
}
