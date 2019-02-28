package com.googlecode.hotire.base.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

  @GetMapping("/test/redirect")
  public RedirectView redirect(RedirectAttributes redirectAttributes) {
    RedirectView redirectView = new RedirectView("/test/hello");
    redirectView.setAttributesMap(ImmutableMap.of("name", "hotire", "id", 1));
    return redirectView;
  }

  @GetMapping("/test/hello")
  public String hello(@RequestParam String name, @RequestParam Integer id) {
    return name + id;
  }

}
