package com.blog.blogproject.application;

import com.blog.blogproject.domain.Board;
import com.blog.blogproject.dto.BoardRequest;
import com.blog.blogproject.dto.BoardResponse;
import com.blog.blogproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponse> getByTags(List<Long> tags) {
        List<Board> boards = boardRepository.findByTag(tags);
        return boards.stream()
                .map(BoardResponse::mapToDto)
                .collect(Collectors.toList());
    }

    public Board getEntity(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
