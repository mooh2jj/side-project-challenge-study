package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.BoardResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagWithBoardListResponse;
import com.study.sidejavachallenge.domain.board.entity.Tag;
import com.study.sidejavachallenge.domain.board.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public TagWithBoardListResponse getTag(Long tagId) {

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new IllegalArgumentException("해당 태그가 없습니다. tagId=" + tagId));

        return TagWithBoardListResponse.builder()
                .titleKor(tag.getTitleKor())
                .titleEng(tag.getTitleEng())
                .boards(tag.getTagBridges().stream()
                        .map(tagBridge -> BoardResponse.mapToDto(tagBridge.getBoard()))
                        .collect(Collectors.toList()))
                .build();
    }
}
