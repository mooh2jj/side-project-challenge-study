package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.BoardCreateRequestDto;
import com.study.sidejavachallenge.domain.board.dto.request.BoardRequestDto;
import com.study.sidejavachallenge.domain.board.dto.request.CategoryDto;
import com.study.sidejavachallenge.domain.board.dto.request.TagDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardResponse;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithCategoryDto;
import com.study.sidejavachallenge.domain.board.dto.response.BoardWithTagListResponse;
import com.study.sidejavachallenge.domain.board.dto.response.TagResponse;
import com.study.sidejavachallenge.domain.board.entity.*;
import com.study.sidejavachallenge.domain.board.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;
    private final TagBridgeRepository tagBridgeRepository;
    private final CategoryBridgeRepository categoryBridgeRepository;

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

    // Board 생성시 태그, 카테고리 4개까지 등록하기
    @Transactional
    @Override
    public BoardResponse
    createBoard(BoardCreateRequestDto boardCreateRequestDto) {
        log.info("BoardServiceImpl createBoard() run");

        // Board 생성
        Board board = Board.builder()
                .title(boardCreateRequestDto.getTitle())
                .content(boardCreateRequestDto.getContent())
                .build();

        boardRepository.save(board);

        // Tag 및 TagBridge 생성
        //List<TagBridge> tagBridges = new ArrayList<>();
        List<TagDto> tagDtos = boardCreateRequestDto.getTags();

        for(TagDto tagDto : tagDtos) {
            Tag tag = Tag.builder()
                    .titleKor(tagDto.getTitleKor())
                    .titleEng(tagDto.getTitleEng())
                    .build();

            tagRepository.save(tag);

            TagBridge tagBridge = TagBridge.builder()
                    .board(board)
                    .tag(tag)
                    .build();

            tagBridgeRepository.save(tagBridge);

            //tagBridges.add(tagBridge);
        }

        // Category 및 CategoryBridge 생성
        //List<CategoryBridge> categoryBridges = new ArrayList<>();
        List<CategoryDto> categoryDtos = boardCreateRequestDto.getCategories();

        for(CategoryDto categoryDto : categoryDtos) {
            Category category = Category.builder()
                    .logo(categoryDto.getLogo())
                    .ord(categoryDto.getOrd())
                    .parentId(categoryDto.getParentId())
                    .title(categoryDto.getTitle())
                    .status(categoryDto.getStatus())
                    .build();

            categoryRepository.save(category);

            CategoryBridge categoryBridge = CategoryBridge.builder()
                    .board(board)
                    .category(category)
                    .build();

            categoryBridgeRepository.save(categoryBridge);

            //categoryBridges.add(categoryBridge);
        }

        return BoardResponse.mapToDto(board);
    }

}
