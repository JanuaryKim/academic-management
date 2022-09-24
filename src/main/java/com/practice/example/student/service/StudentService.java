package com.practice.example.student.service;


import com.practice.example.event.BusinessEvent;
import com.practice.example.event.EventPublisher;
import com.practice.example.exception.BusinessLogicException;
import com.practice.example.exception.ExceptionCode;
import com.practice.example.student.entity.Student;
import com.practice.example.student.repository.StudentRepository;
import com.practice.example.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service //빈 등록
public class StudentService {

    final StudentRepository studentRepository;
    final EventPublisher<Student> eventPublisher;
    final BeanUtils<Student> beanUtils;

    public Student createStudent(Student student) { // 예외처리 -

        verifyStudent(student);
        Student savedStudent = studentRepository.save(student);
//        eventPublisher.publish(savedStudent, BusinessEvent.EventCode.MEMBER_REGISTER); //enum타입 매개변수에 null 가능?

        return savedStudent;
    }



    private void verifyStudent(Student student) { //가입 가능한 학생인지 체크, 존재하면 에러

        Optional<Student> findStudent = studentRepository.findBySecurityNumber(student.getSecurityNumber());
        findStudent.ifPresent(s-> {new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);});

    }


    public Student updateStudent(Student student) { // 예외처리 -
        Student findStudent = verifyExistsStudent(student.getMemberId());
        beanUtils.copyNotNullProperties(student, findStudent);//null 아닌 속성 값 기존 Entity 에 넣음
        studentRepository.save(findStudent);

        return findStudent;
    }

    public Student findStudent(long studentId) {

        Student student = verifyExistsStudent(studentId);

        return student;
    }

    private Student verifyExistsStudent(long studentId) { // id에 해당하는 Student가 있는지 검증, 존재하지 않으면 에러
        Optional<Student> findStudent = studentRepository.findById(studentId);

        return findStudent.orElseThrow(()-> {throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_EXISTS);});

    }

    public void removeStudent(long studentId) {
        verifyExistsStudent(studentId);
        studentRepository.deleteById(studentId);
    }
}
