package com.practice.example.dto;

import lombok.*;


@NoArgsConstructor
@Setter
@Getter
public class SingleResponseDto <T> {

    private T data;

}
