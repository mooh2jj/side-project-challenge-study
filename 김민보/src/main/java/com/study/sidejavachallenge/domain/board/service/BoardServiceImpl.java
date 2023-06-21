package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardResponse;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.entity.Board;
import com.study.sidejavachallenge.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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

    // boardId를 통해 최대 4뎁스를 갖는 category 출력하기
    @Override
    public BoardWithCategoryDto getBoardWithCategory(Long boardId) {
        log.info("BoardServiceImpl getBoardWithCategory() run");
        // category 정보를 어떻게 가져올 것인가?
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));

        return BoardWithCategoryDto.mapToDto(board);
    }

    // 요청파라미터를 categoryList(categoryIds=1,2,3,4)로 보내고 반환은 boardList로 받기
    @Override
    public List<BoardWithCategoryDto> getCategoriesByBoardId(BoardRequestDto boardRequestDto) {
        log.info("BoardServiceImpl getCategoriesByBoardId() run");
        return boardRepository.findBoards(boardRequestDto);
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
