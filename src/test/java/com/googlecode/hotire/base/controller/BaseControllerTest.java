package com.googlecode.hotire.base.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.googlecode.hotire.base.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseControllerTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  BaseService baseService;

  @Test
  public void test() {
    when(baseService.getName()).thenReturn("tire.ho");

    String result = restTemplate.getForObject("/test/name",String.class);
    assertEquals(result, "tire.ho");
  }
}