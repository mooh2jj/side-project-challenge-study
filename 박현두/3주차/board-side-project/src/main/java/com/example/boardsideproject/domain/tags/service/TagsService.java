package com.example.boardsideproject.domain.tags.service;

import com.example.boardsideproject.dto.TagsUpdateDto;

public interface TagsService {
    String createTags(String tagName);
    void updateTags(TagsUpdateDto tagsUpdateDto);
    void deleteTags(long tagsId, long boardsId) ;
    void getAllTags();

    String createBoardTags(String tags);
}
