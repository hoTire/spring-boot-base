package com.googlecode.hotire.base.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.hotire.base.domain.Person;
import com.googlecode.hotire.base.service.PersonService;
import com.googlecode.hotire.base.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("SessionAttributes Test")
@Slf4j
@WebMvcTest(PersonController.class)
class PersonControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  PersonService personService;

  @Test
  void post_person() throws Exception {
    final Person person = RandomUtils.createRandomPerson();
    when(personService.save(person)).thenReturn(person);
    final String json = objectMapper.writeValueAsString(person);
    log.info(json);

    mockMvc.perform(post("/test/person")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
      .andExpect(status().isCreated())
      .andExpect(request().sessionAttribute("person", notNullValue()))
      .andDo(print());
  }

  @Test
  void patch_person() throws Exception {
    final Person person = RandomUtils.createRandomPerson();
    when(personService.patch(person)).thenReturn(person);
    person.setId(1000);
    person.setAge(20);

    final String json = objectMapper.writeValueAsString(person);
    log.info(json);

    person.setId(1);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute("person", person);

    mockMvc.perform(patch("/test/person")
        .session(session)
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
      .andExpect(status().isOk())
      .andDo(print());
  }

  @DisplayName("청소년")
  @Test
  void patch_person_bad_request() throws Exception {
    final Person person = RandomUtils.createRandomPerson();
    when(personService.patch(person)).thenReturn(person);
    person.setAge(19);
    MockHttpSession session = new MockHttpSession();
    session.setAttribute("person", person);

    mockMvc.perform(patch("/test/person").session(session))
      .andExpect(status().isBadRequest())
      .andDo(print());
  }

  @DisplayName("세션이 없다...")
  @Test
  void patch_person_without_session() throws Exception {
    final Person person = RandomUtils.createRandomPerson();
    when(personService.patch(person)).thenReturn(person);

    mockMvc.perform(patch("/test/person"))
      .andExpect(status().is5xxServerError())
      .andDo(print());
  }
}