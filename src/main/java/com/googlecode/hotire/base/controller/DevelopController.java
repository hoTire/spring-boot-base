package com.googlecode.hotire.base.controller;

import com.googlecode.hotire.base.service.AccountService;
import com.googlecode.hotire.base.utils.NotProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@NotProfile("product")
@Controller
public class DevelopController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/test/login/{id}")
  public RedirectView login(@PathVariable String id) {
    accountService.login(id);
    return new RedirectView("/hello");
  }
}
