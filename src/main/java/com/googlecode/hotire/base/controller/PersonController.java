package com.googlecode.hotire.base.controller;

import com.googlecode.hotire.base.domain.Person;
import com.googlecode.hotire.base.service.PersonService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@RequestMapping("/test/person")
@RestController
@SessionAttributes("person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping
  public ResponseEntity save(@RequestBody Person person, Model model) {
    final Person saved = personService.save(person);
    model.addAttribute("person", saved);
    return ResponseEntity.created(URI.create("/test")).body(saved);
  }

  @PatchMapping
  public ResponseEntity patch(@ModelAttribute("person") Person person,
    SessionStatus sessionStatus) {
    final Person patched = personService.patch(person);
    sessionStatus.isComplete();
    return ResponseEntity.ok().body(patched);
  }
}
