package com.example.boardsideproject.domain.tags.service;

import com.example.boardsideproject.dto.TagsUpdateDto;
import com.example.boardsideproject.entity.Tags;
import com.example.boardsideproject.domain.tags.repository.TagsBridgesRepository;
import com.example.boardsideproject.domain.tags.repository.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService{

    private final TagsRepository tagsRepository;
    private final TagsBridgesRepository tagsBridgesRepository;
    @Override
    public String createTags(String tagName) {
        Optional<Tags> optionalTags =  tagsRepository.findByName(tagName);
        if(optionalTags.isEmpty()){
            Tags tags = Tags.builder()
                    .name(tagName)
                    .build();
            tagsRepository.save(tags);
            return "태그 생성에 성공하였습니다.";
        }else{
            return "이미 존재하는 태그입니다.";
        }
    }

    @Override
    public void updateTags(TagsUpdateDto tagsUpdateDto) {
        Optional<Tags> optionalTags = tagsRepository.findById(tagsUpdateDto.getTagsId());
        if(optionalTags.isPresent()){
            Tags tags = optionalTags.get();
            tags.update(tagsUpdateDto.getTagName());
            tagsRepository.save(tags);
        }else{
            throw new IllegalArgumentException("해당 태그가 존재하지 않습니다.");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteTags(long tagsId, long boardsId) {
        tagsBridgesRepository.deleteByTagsIdAndBoardsId(tagsId, boardsId);
        tagsRepository.deleteById(tagsId);
    }

    @Override
    public void getAllTags() {

    }

    @Override
    public String createBoardTags(String tags) {
        return null;
    }
}
