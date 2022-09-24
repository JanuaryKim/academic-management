package com.practice.example.student.mapper;


import com.practice.example.student.dto.StudentDto;
import com.practice.example.student.dto.StudentResponseDto;
import com.practice.example.student.entity.Student;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")  // (1)
public interface StudentMapper {

    default Student studentPostDtoToStudent(StudentDto.Post studentPostDto) {

        if(studentPostDto == null)
            return null;

        Student student = new Student();
        student.setName(studentPostDto.getName());
        student.setStudentStatus(studentPostDto.getStatus());
        student.setGrade(studentPostDto.getGrade());
        student.setSecurityNumber(studentPostDto.getSecurityNumber());

        return student;
    }

    Student studentPatchDtoToStudent(StudentDto.Patch studentPatchDto);

    StudentResponseDto studentToStudentResponseDto(Student student);
}
