package com.study.sidejavachallenge.domain.board.repository;

import com.study.sidejavachallenge.domain.board.dto.request.CategoryRequestDto;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;
import com.study.sidejavachallenge.domain.board.entity.Category;

import java.util.List;

public interface CategoryRepositoryCustom {

    List<CategoryResponse> findCategory(CategoryRequestDto categoryRequestDto);
}
