package com.practice.example.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidStudentStatusValidator.class)
public @interface ValidStudentStatus {
    String message() default "존재하지 않는 전공입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
