package com.practice.example.validator;

import com.practice.example.student.entity.Student;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidStudentStatusValidator implements ConstraintValidator<ValidStudentStatus, Student.StudentStatus> {
    @Override
    public boolean isValid(Student.StudentStatus value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        int ordinal = value.ordinal();
        return ordinal >= 1 && ordinal <= Student.StudentStatus.values().length;
    }

    @Override
    public void initialize(ValidStudentStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
