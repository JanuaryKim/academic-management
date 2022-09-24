package com.practice.example.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidGradeValidator.class})
public @interface ValidGrade {
    String message() default "올바르지 않은 학년입니다 (EX : 1 ~ 3)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
