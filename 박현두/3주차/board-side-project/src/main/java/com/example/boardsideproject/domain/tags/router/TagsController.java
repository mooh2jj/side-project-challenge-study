package com.example.boardsideproject.domain.tags.router;


import com.example.boardsideproject.dto.TagsUpdateDto;
import com.example.boardsideproject.domain.tags.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<String> updateTag(@RequestBody TagsUpdateDto tagsUpdateDto) {
        tagsService.updateTags(tagsUpdateDto);
        return ResponseEntity.ok().body("태그 수정에 성공하였습니다.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTag(long tagsId, long boardsId) {
        tagsService.deleteTags(tagsId, boardsId);
        return ResponseEntity.ok().body("태그 삭제에 성공하였습니다.");
    }
}
