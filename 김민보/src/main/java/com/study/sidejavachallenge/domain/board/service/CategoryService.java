package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.request.CategoryRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    // 카테고리 조회 (카테고리 최소 3개인지 검증)
    List<CategoryResponse> getCategory(CategoryRequestDto categoryRequestDto);

    // 카테고리 삭제 (실제 삭제가 아닌 상태변경)
    CategoryResponse deleteCategory(Long categoryId);
}
