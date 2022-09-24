package com.practice.example.student.controller;



import com.practice.example.student.dto.StudentDto;

import com.practice.example.student.dto.StudentResponseDto;
import com.practice.example.student.entity.Student;
import com.practice.example.student.mapper.StudentMapper;
import com.practice.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Validated
@Slf4j
@RestController //리턴 값을 데이터 자체로 보내기위해, (JSON으로 변환된다)
@RequestMapping("/v1/student")
@RequiredArgsConstructor //상수 멤버변수 초기화 생성자 자동 생성
public class StudentController {

    final StudentService studentService;
    final StudentMapper mapper;

    @PostMapping
    public ResponseEntity postStudent(@Valid @RequestBody StudentDto.Post studentDto) {
        log.info("StudentController.postStudent");
        Student postedStudent = studentService.createStudent(mapper.studentPostDtoToStudent(studentDto));
        StudentResponseDto studentResponseDto = mapper.studentToStudentResponseDto(postedStudent);
        return new ResponseEntity(studentResponseDto, HttpStatus.CREATED);
    }



    @PatchMapping("/{student-id}")
    public ResponseEntity patchStudent(@Positive @PathVariable("student-id") long studentId,
                                       @Valid @RequestBody StudentDto.Patch studentPatchDto) {
        log.info("StudentController.patchStudent");
        studentPatchDto.setStudentId(studentId);
        Student student = studentService.updateStudent(mapper.studentPatchDtoToStudent(studentPatchDto));
        StudentResponseDto studentResponseDto = mapper.studentToStudentResponseDto(student);

        return new ResponseEntity(studentResponseDto,HttpStatus.OK);
    }


    @GetMapping("/{student-id}")
    public ResponseEntity getStudent(@PathVariable("student-id") @Positive long studentId) {
        log.info("StudentController.getStudent");

        Student student = studentService.findStudent(studentId);
        StudentResponseDto studentResponseDto = mapper.studentToStudentResponseDto(student);
        return new ResponseEntity(studentResponseDto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getStudents() {
        log.info("StudentController.getStudents");
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity deleteStudent(@PathVariable("student-id") @Positive int studentId) {
        log.info("StudentController.deleteStudent");
        studentService.removeStudent(studentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
