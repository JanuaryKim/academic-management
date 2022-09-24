package com.practice.example.major.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MajorResponseDto {

    private Long majorId;

    private String majorName;

    private String majorCode;
}
