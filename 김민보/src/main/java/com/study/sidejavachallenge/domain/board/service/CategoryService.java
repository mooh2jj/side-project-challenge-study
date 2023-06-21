package com.study.sidejavachallenge.domain.board.service;

import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;

public interface CategoryService {

    // 카테고리 삭제 (실제 삭제가 아닌 상태변경)
    CategoryResponse deleteCategory(Long categoryId);
}
