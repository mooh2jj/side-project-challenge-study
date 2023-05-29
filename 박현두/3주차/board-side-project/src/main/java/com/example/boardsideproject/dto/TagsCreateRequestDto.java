package com.example.boardsideproject.dto;

import com.example.boardsideproject.entity.Tags;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class TagsCreateRequestDto {

    long boardId;

    List<String> tags;

    public List<Tags> toTagsEntityList(){
        return tags.stream().map(tag -> Tags.builder().name(tag).build()).collect(Collectors.toList());
    }
}
