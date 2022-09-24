package com.practice.example.major.controller;


import com.google.gson.Gson;
import com.practice.example.major.dto.MajorDto;
import com.practice.example.major.mapper.MajorMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({MajorController.class, MajorMapper.class})
@AutoConfigureMockMvc
public class MajorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MediaType mediaType = MediaType.APPLICATION_JSON;

    @Autowired
    private Gson gson;

    @Test
    public void postMajorTest() throws Exception {

        MajorDto.Post post = MajorDto.Post.builder().majorCode("CPS").majorName("Computer Science").build();

        String content = gson.toJson(post);

        ResultActions actions = mockMvc.perform(post("/v1/majors")
                .accept(mediaType)
                .contentType(mediaType)
                .content(content)
        );

        MvcResult result = actions.andExpect(status().isCreated()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void patchMajorTest() throws Exception {

        //given

        Long majorId = 1L;
        MajorDto.Patch patch = MajorDto.Patch.builder().majorName("Computer Develop Science").build();


        String content = gson.toJson(patch);


        //when
        ResultActions actions = mockMvc.perform(patch("/v1/majors/{major-id}", majorId)
                .accept(mediaType)
                .contentType(mediaType)
                .content(content)
        );

        //then
        MvcResult result = actions.andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void getMajorTest() throws Exception {

        //given

        Long majorId = 1L;




        //when
        ResultActions actions = mockMvc.perform(get("/v1/majors/{major-id}", majorId)
                .accept(mediaType)
                .contentType(mediaType)
        );

        //then
        MvcResult result = actions.andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void deleteMajorTest() throws Exception {

        //given

        Long majorId = 1L;




        //when
        ResultActions actions = mockMvc.perform(delete("/v1/majors/{major-id}", majorId)
                .accept(mediaType)
                .contentType(mediaType)
        );

        //then
        MvcResult result = actions.andExpect(status().isNoContent()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void getMajorsTest() throws Exception {

        //given



        //when
        ResultActions actions = mockMvc.perform(get("/v1/majors")
                .accept(mediaType)
                .contentType(mediaType)
        );

        //then
        MvcResult result = actions.andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }


}
