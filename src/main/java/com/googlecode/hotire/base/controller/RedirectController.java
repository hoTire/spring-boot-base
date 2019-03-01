package com.googlecode.hotire.base.controller;

import com.google.common.collect.ImmutableMap;
import com.googlecode.hotire.base.domain.Person;
import com.googlecode.hotire.base.utils.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

  @GetMapping("/test/redirect")
  public RedirectView redirect(RedirectView redirectView) {
    redirectView.setUrl("/test/hello");
    redirectView.setAttributesMap(ImmutableMap.of("name", "hotire", "id", 1));
    return redirectView;
  }

  @GetMapping("/test/hello")
  public String hello(@RequestParam String name, @RequestParam Integer id) {
    return name + id;
  }

  @GetMapping("/test/redirect/flash")
  public RedirectView flash(RedirectView redirectView, RedirectAttributes redirectAttributes) {
    redirectView.setUrl("/test/flash");
    redirectAttributes.addFlashAttribute("flash", RandomUtils.createRandomPerson());
    return redirectView;
  }

  @GetMapping("/test/flash")
  public Person flash(@ModelAttribute("flash") Person person) {
    return person;
  }
}
