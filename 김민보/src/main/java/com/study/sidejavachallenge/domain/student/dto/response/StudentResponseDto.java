package com.study.sidejavachallenge.domain.student.dto.response;

import com.study.sidejavachallenge.domain.student.entity.Student;
import lombok.*;

@Getter
//@Setter
//@NoArgsConstructor
@ToString
public class StudentResponseDto {

    private final int count;
    private final int total;
    private final double average;


    @Builder
    public StudentResponseDto(int count, int total, double average) {
        this.count = count;
        this.total = total;
        this.average = average;
    }

    static public StudentResponseDto mapToDto(Student student) {

        return StudentResponseDto.builder()
                .count(student.getCount())
                .total(student.getTotal())
                .average(student.getAverage())
                .build();
    }

    /*
    public static SubjectResponseDto from(Student student, List<SubjectRequestDto> subjects) {
        return SubjectResponseDto.builder()
                .average(student.calculateAverage(subjects))
                .build();
    }

    public void calculateAverage(int score) {
        this.count++;
        this.total += score;
        this.average = (double) this.total / this.count;
    }
    */
}
