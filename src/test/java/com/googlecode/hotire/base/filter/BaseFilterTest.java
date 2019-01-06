package com.googlecode.hotire.base.filter;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.hotire.base.controller.BaseController;
import com.googlecode.hotire.base.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseFilterTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BaseController()).build();
    }

    @Test
    public void setMessage() throws Exception {

        String message = "Hello";
        String language = "한국";
        String user = "tire.ho";

        String json = objectMapper.writeValueAsString(new Message(user,language));
        log.info(json);
        mockMvc.perform(post("/test/filter")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }

}