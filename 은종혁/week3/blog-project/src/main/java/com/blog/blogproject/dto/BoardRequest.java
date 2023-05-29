package com.blog.blogproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardRequest {

    private String title;
    private String contents;

    private Long userId;

    private List<Long> tagId;
}
