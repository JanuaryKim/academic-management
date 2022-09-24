package com.practice.example;

public class main {
    public static void main(String[] args) {

        String value = "010-223-2234";

        System.out.println("결과 : "+ value.matches("010-\\d{3,4}-\\d{4}"));
    }
}
