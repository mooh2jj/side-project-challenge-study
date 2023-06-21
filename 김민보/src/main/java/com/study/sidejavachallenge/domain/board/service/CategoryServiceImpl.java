package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.CategoryRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;
import com.study.sidejavachallenge.domain.board.entity.Category;
import com.study.sidejavachallenge.domain.board.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getCategory(CategoryRequestDto categoryRequestDto) {

        return categoryRepository.findCategory(categoryRequestDto);
    }

    // 카테고리 삭제 (실제 삭제가 아닌 상태변경)
    @Transactional
    @Override
    public CategoryResponse deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. categoryId=" + categoryId));

        category.delete();

        return CategoryResponse.mapToDto(category);
    }
}

