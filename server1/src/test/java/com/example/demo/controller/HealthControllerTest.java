package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
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

    @Autowired
    Environment env;

    @Test
    void healthControllerTest() throws Exception {
        //given
        String[] profiles = env.getActiveProfiles();
        for (String profile : profiles) {
            System.out.println("profile = " + profile);
        }
        //when
        ResultActions result = mockMvc.perform(get("/health"));
        //then
//        MvcResult mvcResult = result.andExpect(status().isOk())
//                .andExpect(content().string("server1 is running!!!"))
//                .andReturn();

//        assertThat(env.getActiveProfiles()).contains("test");
//        assertThat(username).isEqualTo("test_username");
    }
}