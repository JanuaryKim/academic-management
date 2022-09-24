package com.practice.example.student.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Gson gson;


    @Test
    public void postStudentTest() throws Exception {

//        //given
//        StudentPostDto studentPostDto = StudentPostDto.builder().name("kim").major(Student.Major.MATH_AND_SCIENCE)
//                .grade(1).classs(9).securityNumber("123444-9876543").build();
//        String content = gson.toJson(studentPostDto);
//
//
//        //when
//        ResultActions ac = mockMvc.perform(
//                post("/v1/student")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content));
//        //then
//        System.out.println(ac.andReturn().getResponse().getContentAsString());
    }

}
