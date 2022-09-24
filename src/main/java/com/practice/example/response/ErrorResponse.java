package com.practice.example.response;

import com.practice.example.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ErrorResponse { //클라이언트에게 Json 형태로 뿌려질 객체

    private Integer status;
    private String message;
    private List<MyFieldError> myFieldErrors;
    private List<MyConstraintViolationError> myConstraintViolationErrors;


    private ErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private ErrorResponse(List<MyFieldError> myFieldErrors, List<MyConstraintViolationError> myConstraintViolationErrors) {

        this.myFieldErrors = myFieldErrors;
        this.myConstraintViolationErrors = myConstraintViolationErrors;
    }



    public static ErrorResponse of(ExceptionCode exceptionCode) { //BusinessLogicException 관련

        return new ErrorResponse(exceptionCode.getCode(), exceptionCode.getMessage()); //status 와 message 만으로 초기화 하는 경우
    }

    public static ErrorResponse of(BindingResult bindingResult) { // MethodArgumentNotValidException 관련

        return new ErrorResponse(MyFieldError.of(bindingResult.getFieldErrors()), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> constraintViolations) { // ConstraintViolationException 관련

        return new ErrorResponse(null, MyConstraintViolationError.of(constraintViolations));
    }


    @AllArgsConstructor
    @Getter
    private static class MyFieldError {
        String field;
        Object value;
        String reason;



        public static List<MyFieldError> of(List<org.springframework.validation.FieldError> list) {

            return list.stream().map(fieldError -> {
                MyFieldError myFieldError = new MyFieldError(fieldError.getField(),
                        fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString()
                        ,fieldError.getDefaultMessage());

                return myFieldError;
            }).collect(Collectors.toList());

        }
    }

    @AllArgsConstructor
    @Getter
    private static class MyConstraintViolationError{
        String field;
        Object value;
        String reason;

        public static List<MyConstraintViolationError> of(Set<ConstraintViolation<?>> set){

            return set.stream().map(c -> {
                return new MyConstraintViolationError(
                        c.getPropertyPath().toString(),
                        c.getInvalidValue(),
                        c.getMessage());
            }).collect(Collectors.toList());
        }
    }


}
