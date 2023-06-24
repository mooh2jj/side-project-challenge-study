package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.domain.board.dto.request.TagDto;
import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.repository.TagRepository;
import com.study.sidejavachallenge.domain.board.service.TagServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class TagTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagServiceImpl tagService;

    @Test
    @DisplayName("태그 validation 테스트")
    void testTagValidation() {

        // given
        TagDto tagDto = TagDto.builder()
                .titleKor("태그1")
                .titleEng("tag1")
                .build();

        Tag tag = Tag.testMapToEntity(1L, tagDto.getTitleKor(), tagDto.getTitleEng());

        when(tagRepository.findById(tag.getId())).thenReturn(Optional.of(tag)); // findById 모킹

        // when
        Tag findTag = tagRepository.findById(tag.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 태그가 없습니다. tagId=" + tag.getId()));

        TagResponse.mapToDto(findTag);

        TagResponse deleteTag = tagService.deleteTag(tag.getId());

        // then
        assertThat(findTag).isNotNull();
        assertThat(findTag.getTitleKor()).isEqualTo("태그1");
    }
}