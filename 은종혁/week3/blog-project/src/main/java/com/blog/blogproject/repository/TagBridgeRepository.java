package com.blog.blogproject.repository;

import com.blog.blogproject.domain.TagBridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagBridgeRepository extends JpaRepository<TagBridge, Long> {

    TagBridge findByBoardId(Long boardId);
}
