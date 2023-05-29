package com.study.sidejavachallenge.domain.board.repository;

import com.study.sidejavachallenge.domain.board.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
