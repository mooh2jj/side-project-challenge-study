package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagWithBoardListResponse;

public interface TagService {

    TagWithBoardListResponse getTag(Long tagId);

    // 태그 삭제 ( cascade = CascadeType.ALL 설정으로 자식엔티티인 TagBridge도 삭제됨)
    TagResponse deleteTag(Long tagId);
}
