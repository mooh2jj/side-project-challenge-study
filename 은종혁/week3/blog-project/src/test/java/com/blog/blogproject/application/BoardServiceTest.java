package com.blog.blogproject.application;

import com.blog.blogproject.repository.TagRepository;
import com.blog.blogproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired UserRepository userRepository;
    @Autowired TagRepository tagRepository;


    @BeforeAll
    public void setup() {

    }

    @Test
    public void findBoardByTags() throws Exception {
        //given


        //when

        //then

    }
}