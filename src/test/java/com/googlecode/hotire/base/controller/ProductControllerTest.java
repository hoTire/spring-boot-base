package com.googlecode.hotire.base.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.googlecode.hotire.base.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("product")
@Slf4j
@WebMvcTest(DevelopController.class)
class ProductControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  AccountService accountService;

  @Test
  void login() throws Exception {
    mockMvc.perform(get("/test/login/admin"))
      .andExpect(status().isNotFound())
      .andDo(print());
  }
}
