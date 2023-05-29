package com.study.sidejavachallenge.domain.board.repository;

import com.study.sidejavachallenge.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
