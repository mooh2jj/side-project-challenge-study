package com.example.boardsideproject.domain.tags.repository;

import com.example.boardsideproject.entity.TagBridges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagsBridgesRepository extends JpaRepository<TagBridges,Long> {

    @Query("delete from TagBridges t where t.tags.tagId = ?1 and t.boards.boardId = ?2")
    void deleteByTagsIdAndBoardsId(long tagsId, long boardsId);
}
