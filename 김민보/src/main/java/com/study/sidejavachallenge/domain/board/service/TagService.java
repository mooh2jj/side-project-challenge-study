package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.TagWithBoardListResponse;

public interface TagService {

    TagWithBoardListResponse getTag(Long tagId);
}
