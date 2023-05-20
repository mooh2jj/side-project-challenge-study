package com.example.boardsideproject.modules.board.service;

import com.example.boardsideproject.dto.BoardResponseDto;
import com.example.boardsideproject.entity.Boards;

import com.example.boardsideproject.modules.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

        private final BoardRepository boardRepository;

        @Override
        public BoardResponseDto getBoard(Long id) {
            Boards board = boardRepository.findById(id)
                    .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

            return BoardResponseDto.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .tags(board.getTagBridges().stream().map(tagBridges -> tagBridges.getTags().getName()).collect(Collectors.toList()))
                    .build();
        }
}
