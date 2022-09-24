package com.practice.example.major.mapper;

import com.practice.example.major.dto.MajorDto;
import com.practice.example.major.dto.MajorResponseDto;
import com.practice.example.major.entity.Major;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MajorMapper {

    Major majorPostDtoToMajor(MajorDto.Post dto);
    MajorResponseDto majorToMajorResponseDto(Major major);
    Major majorPatchDtoToMajor(MajorDto.Patch dto);


}
