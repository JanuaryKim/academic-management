package com.practice.example.student.dto;

import com.practice.example.student.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    Long studentId;

    String name;

    Student.StudentStatus status;

    Integer grade;


}
