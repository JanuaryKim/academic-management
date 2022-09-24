package com.practice.example.major.controller;

import com.practice.example.dto.MultiResponseDto;
import com.practice.example.dto.SingleResponseDto;
import com.practice.example.helper.major.stub.MajorDataStub;
import com.practice.example.major.dto.MajorDto;
import com.practice.example.major.dto.MajorResponseDto;
import com.practice.example.major.entity.Major;
import com.practice.example.major.mapper.MajorMapper;
import com.practice.example.major.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/majors")
@Validated
public class MajorController {

    private final MajorMapper mapper;
    private final MajorService service;


    @PostMapping
    public ResponseEntity postMajor(@Valid @RequestBody MajorDto.Post majorDto) {

        Major major = mapper.majorPostDtoToMajor(majorDto);
        MajorResponseDto majorResponseDto = mapper.majorToMajorResponseDto(major);

        return new ResponseEntity(majorResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{major-id}")
    public ResponseEntity patchMajor(@PathVariable("major-id")@Positive long majorId, @Valid @RequestBody MajorDto.Patch majorDto) {

        Major major = mapper.majorPatchDtoToMajor(majorDto);
        MajorResponseDto majorResponseDto = mapper.majorToMajorResponseDto(major);

        return new ResponseEntity(majorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{major-id}")
    public ResponseEntity getMajor(@PathVariable("major-id") @Positive long majorId) {

        Major major = MajorDataStub.getMajor(majorId);
        MajorResponseDto majorResponseDto = mapper.majorToMajorResponseDto(major);

        SingleResponseDto<MajorResponseDto> singleResponseDto = new SingleResponseDto<>();
        singleResponseDto.setData(majorResponseDto);
        ResponseEntity responseEntity = new ResponseEntity(singleResponseDto, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity getMajors() {

        Page<Major> majorPage = MajorDataStub.getMajorPage();

        MultiResponseDto<MajorResponseDto> multiResponseDto = new MultiResponseDto(majorPage.getContent(), majorPage);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{major-id}")
    public ResponseEntity deleteMajors(@PathVariable("major-id") @Positive long majorId) {



        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
