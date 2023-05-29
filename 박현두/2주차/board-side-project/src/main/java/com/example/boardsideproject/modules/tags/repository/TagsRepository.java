package com.example.boardsideproject.modules.tags.repository;

import com.example.boardsideproject.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tags, Long> {
    Optional<Tags> findByName(String name);
}
