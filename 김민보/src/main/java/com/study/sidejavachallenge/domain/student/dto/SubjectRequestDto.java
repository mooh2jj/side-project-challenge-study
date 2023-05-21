package com.study.sidejavachallenge.domain.student.dto;

import com.study.sidejavachallenge.domain.student.dto.request.StudentRequestDto;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class SubjectRequestDto {
    @Valid List<StudentRequestDto> studentRequestDtos;
}
