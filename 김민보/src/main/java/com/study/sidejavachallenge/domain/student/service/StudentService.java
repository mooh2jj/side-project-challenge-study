package com.study.sidejavachallenge.domain.student.service;

import com.study.sidejavachallenge.domain.student.dto.SubjectRequestDto;
import com.study.sidejavachallenge.domain.student.dto.request.SearchRequestDto;
import com.study.sidejavachallenge.domain.student.dto.request.StudentRequestDto;
import com.study.sidejavachallenge.domain.student.dto.response.SearchResponseDto;
import com.study.sidejavachallenge.domain.student.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {

    // get대신 save나 create로바꾸기
    List<StudentResponseDto> getStudentAverage(List<StudentRequestDto> requestDtos);

    List<SearchResponseDto> getStudentList(SearchRequestDto requestDto);
}
