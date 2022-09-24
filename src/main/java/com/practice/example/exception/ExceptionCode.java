package com.practice.example.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
public enum ExceptionCode {

    MEMBER_EXISTS(409, "Member exists"),
    MEMBER_NOT_EXISTS(404, "Member not exists"),

    MAJOR_EXISTS(409, "Major exists");



    private int code;

    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
