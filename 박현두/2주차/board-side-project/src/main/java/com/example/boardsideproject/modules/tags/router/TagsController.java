package com.example.boardsideproject.modules.tags.router;


import com.example.boardsideproject.modules.tags.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagsController {

    private final TagsService tagsService;
    @PostMapping
    public ResponseEntity<String> createTag(String tagName) {
        tagsService.createTags(tagName);
        return ResponseEntity.ok().body("태그 생성에 성공하였습니다.");
    }
}
