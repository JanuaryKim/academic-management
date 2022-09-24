package com.practice.example.student.dto;

import com.practice.example.student.entity.Student;
import com.practice.example.validator.ValidGrade;
import com.practice.example.validator.ValidStudentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class StudentDto {

    @Getter
    public static class Post{

        @NotBlank(message = "학생의 이름은 비어있어선 안됩니다.")
        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$") //문자열이 아닌 값 숫자값이 들어와도 검증해줌
                String name; //null, "", " ", 모두 불허용

        @NotNull(message = "학생 비어 있어선 안됩니다.")
        @ValidStudentStatus
        Student.StudentStatus status; //enum 에서 정해진 수까지만

        //Integer 타입이기 때문에 @NotEmpty, @NotBlank 사용 불가. 정수 타입이기때문에 "", " " 검사 불가한듯
        @NotNull(message = "학년은 비어 있어선 안됩니다")
        @ValidGrade //사용자 정의 애노테이션 사용해봄
                Integer grade; // 1 ~ 3 까지 허용


        @NotBlank(message = "주민번호는 비어 있어선 안됩니다.")
        @Pattern(regexp = "^([0-9]{6})(-[0-9]{7})$") //우선 - 기준으로 앞에 6자 뒤에 7자 검사만 함
        String securityNumber;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Patch{
        @Positive
        Long studentId;

        @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$") //문자열이 아닌 값 숫자값이 들어와도 검증해줌
        String name; //null 허용. "", " " 불허용

        @ValidStudentStatus
        Student.StudentStatus status; //null 허용.

        @ValidGrade
        Integer grade; //null 허용.

    }
}
