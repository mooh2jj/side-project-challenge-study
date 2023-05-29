package com.blog.blogproject.application;

import com.blog.blogproject.domain.TagBridge;
import com.blog.blogproject.repository.TagBridgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagBridgeService {

    private final TagBridgeRepository tagBridgeRepository;


    public TagBridge getEntityByBoard(Long boardId) {
        return tagBridgeRepository.findByBoardId(boardId);
    }
}
