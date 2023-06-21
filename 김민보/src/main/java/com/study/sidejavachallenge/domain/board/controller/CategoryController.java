package com.study.sidejavachallenge.domain.board.controller;

import com.study.sidejavachallenge.domain.board.dto.request.CategoryRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;
import com.study.sidejavachallenge.domain.board.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 조회 (카테고리 최소 3개인지 검증)
    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryResponse>> getCategory(CategoryRequestDto categoryRequestDto) {

        List<CategoryResponse> category = categoryService.getCategory(categoryRequestDto);
        log.info("category = {}", category);

        return ResponseEntity.ok(category);
    }


    // 카테고리 삭제 (실제 삭제가 아닌 상태변경)
    @PatchMapping("/api/categories/{categoryId}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Long categoryId) {

        CategoryResponse deleteCategory = categoryService.deleteCategory(categoryId);
        log.info("deleteCategory = {}", deleteCategory);

        return new ResponseEntity<>(deleteCategory, HttpStatus.OK);
    }
}
