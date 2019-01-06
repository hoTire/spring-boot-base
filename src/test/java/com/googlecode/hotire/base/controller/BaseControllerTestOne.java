package com.googlecode.hotire.base.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.googlecode.hotire.base.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Web 과 관련된 Bean만 등록된다.
 * Controller, ControllerAdvice, Converter, Filter 등..
 *
 * Service, Component, Repository 등록이 안된다.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BaseController.class)
public class BaseControllerTestOne {

  @MockBean
  BaseService baseService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void test() throws Exception {
    when(baseService.getName()).thenReturn("tire.ho");

    mockMvc.perform(get("/test/name"))
            .andExpect(content().string("tire.ho"))
            .andExpect(status().isOk())
            .andDo(print());
  }
}

