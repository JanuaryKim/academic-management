package com.practice.example.major.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MajorDto {

    @AllArgsConstructor
    @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    public static class Post{

        @NotBlank(message = "전공명은 비어 있을 수 없습니다.")
        private String majorName;

        @NotBlank(message = "전공 코드는 비어 있을 수 없습니다.")
        @Size(min = 3, max = 3)
        @Pattern(regexp = "^([A-Z]){3}$", message = "전공 코드는 3자리 영문이여야 합니다.")
        private String majorCode;
    }

    @AllArgsConstructor
    @Builder
    @Setter
    @Getter
    @NoArgsConstructor
    public static class Patch{

        @NotEmpty(message = "전공명은 공백일 수 없습니다.")
        private String majorName;


        @Size(min = 3, max = 3)
        @Pattern(regexp = "^([A-Z]){3}$", message = "전공 코드는 3자리 영문이여야 합니다.")
        private String majorCode;
    }


}
