package com.example.boardsideproject.domain.board.repository;


import com.example.boardsideproject.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Boards, Long> {

}
