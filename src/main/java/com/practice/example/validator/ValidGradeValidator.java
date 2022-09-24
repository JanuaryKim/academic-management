package com.practice.example.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidGradeValidator implements ConstraintValidator<ValidGrade, Integer> {

    @Override
    public void initialize(ValidGrade constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (value == null)
            return true;

        return (value > 0) && (value < 4);
    }
}