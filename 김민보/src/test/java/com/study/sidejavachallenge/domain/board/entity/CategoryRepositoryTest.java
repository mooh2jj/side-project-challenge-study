package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.domain.board.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;;

    private Category category1, category2;

    @BeforeEach
    void setup() {
        category1 = Category.builder()
                .parentId(0L)
                .title("패션")
                .ord("0")
                .logo("passion_logo.png")
                .status(CategoryStatus.PUBLIC)
                .build();

        category2 = Category.builder()
                .parentId(1L)
                .title("패션_남성")
                .ord("0.0")
                .logo("men_logo.png")
                .status(CategoryStatus.PUBLIC)
                .build();
    }

    @Test
    @DisplayName("카테고리 validation 테스트")
    void categoryValidationTest() {

        // given

        // when
        Category savedCategory1 = categoryRepository.save(category1);
        Category savedCategory2 = categoryRepository.save(category2);

        // then
        assertThat(savedCategory1.getOrd()).isEqualTo("0");
        assertThat(savedCategory2.getOrd()).contains("0.0");

    }
}