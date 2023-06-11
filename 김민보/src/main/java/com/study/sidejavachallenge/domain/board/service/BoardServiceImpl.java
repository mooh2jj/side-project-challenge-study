package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.entity.Board;
import com.study.sidejavachallenge.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public BoardWithTagListResponse getBoard(Long boardId) {
        log.info("BoardServiceImpl getBoard() run");

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));

        return BoardWithTagListResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .tags(board.getTagBridges().stream()
                        .map(tagBridge -> TagResponse.mapToDto(tagBridge.getTag()))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public BoardWithCategoryDto getBoardWithCategory(Long boardId) {
        log.info("BoardServiceImpl getBoardWithCategory() run");
        // category 정보를 어떻게 가져올 것인가?
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));

        return BoardWithCategoryDto.mapToDto(board);
    }

//    @Override
//    public List<BoardResponse> getBoard(Long boardId) {
//
//        List<Tag> tagList = tagBridgeRepository.findById(boardId)
//                                        .stream()
//                                        .map(TagBridge::getTag)
//                                        .collect(Collectors.toList());
//
//        return boardRepository.findBoardByTag(tagList);
//    }
}
