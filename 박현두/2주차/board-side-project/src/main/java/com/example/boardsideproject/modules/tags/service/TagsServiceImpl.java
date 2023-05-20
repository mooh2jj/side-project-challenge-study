package com.example.boardsideproject.modules.tags.service;

import com.example.boardsideproject.entity.Tags;
import com.example.boardsideproject.modules.tags.repository.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService{

    private final TagsRepository tagsRepository;

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
    public void updateTags() {

    }

    @Override
    public void deleteTags() {

    }

    @Override
    public void getAllTags() {

    }
}
