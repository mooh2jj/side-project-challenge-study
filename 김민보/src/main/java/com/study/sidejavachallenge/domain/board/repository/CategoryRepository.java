package com.study.sidejavachallenge.domain.board.repository;

import com.study.sidejavachallenge.domain.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
