package com.googlecode.hotire.base.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
public class RedirectControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void redirect() throws Exception {
    final String redirectedUrl = UriComponentsBuilder.fromPath("/test/hello")
      .queryParam("name", "hotire")
      .queryParam("id", 1).build().toUri().toString();

    mockMvc.perform(get("/test/redirect"))
      .andExpect(status().is3xxRedirection())
      .andExpect(redirectedUrl(redirectedUrl))
      .andDo(print());
  }
}