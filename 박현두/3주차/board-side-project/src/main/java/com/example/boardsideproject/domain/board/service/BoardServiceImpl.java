package com.example.boardsideproject.domain.board.service;

import com.example.boardsideproject.domain.tags.repository.TagsBridgesRepository;
import com.example.boardsideproject.domain.tags.repository.TagsRepository;
import com.example.boardsideproject.dto.BoardResponseDto;
import com.example.boardsideproject.dto.TagsCreateRequestDto;
import com.example.boardsideproject.entity.Boards;

import com.example.boardsideproject.domain.board.repository.BoardRepository;

import com.example.boardsideproject.entity.TagBridges;
import com.example.boardsideproject.entity.Tags;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

        private final BoardRepository boardRepository;
        private final TagsBridgesRepository tagsBridgesRepository;
        private final TagsRepository tagsRepository;
        @Override
        public BoardResponseDto getBoard(Long id) {
            Boards board = boardRepository.findById(id)
                    .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

            return BoardResponseDto.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .tags(Arrays.asList(board.getTags().split(",")))
                    .build();
        }

    @Override
    public BoardResponseDto getBoardTagsEntity(Long id) {
        Boards board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return BoardResponseDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .tags(board.getTagBridges().stream().map(tagBridges -> tagBridges.getTags().getName()).collect(Collectors.toList()))
                .build();
    }
    @Override
    public void addTags(TagsCreateRequestDto dto) {
            Boards boards = boardRepository.findById(dto.getBoardId())
                    .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+dto.getBoardId()));
            boards.addTag(StringUtils.join(dto.getTags(), ','));
            boardRepository.save(boards);
    }
    @Override
    @Transactional
    public void addTagsEntity(TagsCreateRequestDto dto){
        Boards boards = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + dto.getBoardId()));

        List<Tags> tagsList = dto.toTagsEntityList();
        tagsRepository.saveAll(tagsList);

        List<TagBridges> tagBridgesList = tagsList.stream().map(tags -> TagBridges.builder()
                .boards(boards)
                .tags(tags)
                .build()).collect(Collectors.toList());
        tagsBridgesRepository.saveAll(tagBridgesList);
    }

    @Override
    @Transactional
    public void deleteTagsByBoardId(long boardId){
        Boards boards = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + boardId));
        List<TagBridges> tagBridgesList = boards.getTagBridges();
        tagsBridgesRepository.deleteAll(tagBridgesList);

        List<Tags> tagsList = tagBridgesList.stream().map(TagBridges::getTags).collect(Collectors.toList());
        tagsRepository.deleteAll(tagsList);
    }

    @Override
    public void createBoard(TagsCreateRequestDto dto) {

    }
}
