package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class HealthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void healthControllerTest() throws Exception {
        //given
        //when
        ResultActions result = mockMvc.perform(get("/health"));
        //then
        MvcResult mvcResult = result.andExpect(status().isOk())
                .andExpect(content().string("server1 is running!!!"))
                .andReturn();

//        assertThat(env.getActiveProfiles()).contains("test");
//        assertThat(username).isEqualTo("test_username");
    }
}