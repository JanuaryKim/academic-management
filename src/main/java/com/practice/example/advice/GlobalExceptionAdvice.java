package com.practice.example.advice;

import com.practice.example.exception.BusinessLogicException;
import com.practice.example.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBusinessLogic(BusinessLogicException exception) { // 비즈니스적인 문제로 임의로 Exception 던진 경우
        log.error("handleBusinessLogic!");
        ErrorResponse response = ErrorResponse.of(exception.getExceptionCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(exception.getExceptionCode().getCode()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) { // @Valid 로 인해 DTO 내에서 유효성 검증 실패한 경우
        log.error("handleMethodArgumentNotValidException!");
        ErrorResponse response = ErrorResponse.of(exception.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) { // Controller 에서 @Validate 로 인해 유효성 검증 실패한 경우
        log.error("handleConstraintViolationException!");
        ErrorResponse response = ErrorResponse.of(exception.getConstraintViolations());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) { // 필드에 잘못된 타입이 들어올때, 클라이언트 잘못
        log.error("handleHttpMessageNotReadableException!");
        return null;
    }
}
